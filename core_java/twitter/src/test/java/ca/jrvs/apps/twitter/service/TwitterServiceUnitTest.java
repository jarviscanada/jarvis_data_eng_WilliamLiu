package ca.jrvs.apps.twitter.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.when;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceUnitTest {

  @Mock
  CrdDao dao;

  @InjectMocks
  TwitterService service;

  @Test
  public void postTweet() {    // test failed request
    String hashTag = "#abc";
    String text = "@williamyll1 sometext " + hashTag + " " + System.currentTimeMillis();
    Double lat = 1d;
    Double lon = -1d;
    // exception is expected here
    when(dao.create(isNotNull())).thenThrow(new RuntimeException("mock"));
    try {
      service.postTweet(TweetUtil.buildTweet(text, lon, lat));
      fail();
    } catch (RuntimeException e) {
      assertTrue(true);
    }

    when(dao.create(any())).thenReturn(new Tweet());
    Tweet tweet = service.postTweet(TweetUtil.buildTweet("test", 50.0, 0.0));
    assertNotNull(tweet);
  }
}
