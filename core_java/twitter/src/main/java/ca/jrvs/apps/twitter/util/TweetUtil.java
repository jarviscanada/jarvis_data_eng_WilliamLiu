package ca.jrvs.apps.twitter.util;

import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import java.util.ArrayList;

public class TweetUtil {

  public static Tweet buildTweet(String text, Double lon, Double lat) {
    Coordinates coordinates = new Coordinates();
    coordinates.setCoordinates(new ArrayList<Double>() {{
      add(lon);
      add(lat);
    }});

    Tweet tweet = new Tweet();
    tweet.setText(text);
    tweet.setCoordinates(coordinates);

    return tweet;
  }
}
