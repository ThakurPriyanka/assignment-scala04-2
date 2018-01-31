package edu.knoldus

import com.typesafe.config.ConfigFactory
import edu.knoldus.operation.FutureClass
import org.apache.log4j.Logger
import twitter4j.TwitterFactory
import twitter4j.auth.AccessToken





object Application {

  def main(args: Array[String]): Unit = {
    val log = Logger.getLogger(this.getClass)
    val conf = ConfigFactory.load
    val twitters = new TwitterFactory().getInstance()
    val timeToSleep = 10000
    // Authorising with your Twitter Application credentials
    twitters.setOAuthConsumer(conf.getString("twitter.consumer.api.key"),
      conf.getString("twitter.consumer.api.secret"))
    twitters.setOAuthAccessToken(new AccessToken(
      conf.getString("twitter.access.api.token"),
      conf.getString("twitter.access.api.secret")))

    val hashTag = "modi"
    val tweetObject = new FutureClass

    tweetObject.getTweet(hashTag, twitters)
    tweetObject.getCount(hashTag, twitters)

    Thread.sleep(timeToSleep)
    log.info("end")
  }
}

