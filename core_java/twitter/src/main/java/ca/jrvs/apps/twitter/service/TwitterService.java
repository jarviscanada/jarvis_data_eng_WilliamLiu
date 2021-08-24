package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class TwitterService implements Service {

  private CrdDao dao;

  @Autowired
  public TwitterService(CrdDao dao) {
    this.dao = dao;
  }

  private void validatePostTweet(Tweet tweet) {
    // text length <= 140, lat/lon range, id format
    if (tweet.getText().length() > 140) {
      throw new IllegalArgumentException("Tweet text exceeds 140 characters");
    }

    Double lon = tweet.getCoordinates().getCoordinates().get(0);
    Double lat = tweet.getCoordinates().getCoordinates().get(1);
    if (-90d > lat || lat > 90d || -180d > lon || lon > 180d) {
      throw new IllegalArgumentException("Latitude or Longitude out of range");
    }
  }

  private void validateTweetId(String id) {
    try {
      Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid tweet id format");
    }
  }

  /**
   * Validate and post a user input Tweet
   *
   * @param tweet tweet to be created
   * @return created tweet
   * @throws IllegalArgumentException if text exceed max number of allowed characters or lat/long
   *                                  out of range
   */
  @Override
  public Tweet postTweet(Tweet tweet) {
    validatePostTweet(tweet);
    return (Tweet) dao.create(tweet);
  }

  /**
   * Search a tweet by ID
   *
   * @param id     tweet id
   * @param fields set fields not in the list to null
   * @return Tweet object which is returned by the Twitter API
   * @throws IllegalArgumentException if id or fields param is invalid
   */
  @Override
  public Tweet showTweet(String id, String[] fields) {
    validateTweetId(id);

    Tweet findTweet = (Tweet) dao.findById(id);
    Tweet tweet = new Tweet();

    for (String field : fields) {
      switch (field) {
        case "created_at":
          tweet.setCreatedAt(findTweet.getCreatedAt());
          break;
        case "id":
          tweet.setId(findTweet.getId());
          break;
        case "id_str":
          tweet.setIdStr(findTweet.getIdStr());
          break;
        case "text":
          tweet.setText(findTweet.getText());
          break;
        case "entities":
          tweet.setEntities(findTweet.getEntities());
          break;
        case "coordinates":
          tweet.setCoordinates(findTweet.getCoordinates());
          break;
        case "retweet_count":
          tweet.setRetweetCount(findTweet.getRetweetCount());
          break;
        case "favorite_count":
          tweet.setFavoriteCount(findTweet.getFavoriteCount());
          break;
        case "favorited":
          tweet.setFavorited(findTweet.isFavorited());
          break;
        case "retweeted":
          tweet.setRetweeted(findTweet.isRetweeted());
          break;
        default:
          throw new IllegalArgumentException("Invalid field: " + field);
      }
    }

    return tweet;
  }

  /**
   * Delete Tweet(s) by id(s).
   *
   * @param ids tweet IDs which will be deleted
   * @return A list of Tweets
   * @throws IllegalArgumentException if one of the IDs is invalid.
   */
  @Override
  public List<Tweet> deleteTweets(String[] ids) {
    List<Tweet> tweetList = new ArrayList<>();
    for (String id : ids) {
      validateTweetId(id);
      tweetList.add((Tweet) dao.deleteById(id));
    }
    return tweetList;
  }
}
