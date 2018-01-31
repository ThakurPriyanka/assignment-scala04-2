package edu.knoldus.operation

import org.apache.log4j.Logger
import twitter4j.Twitter

import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global

class FutureClass {
  val tweetObject = new Tweet
  val log = Logger.getLogger(this.getClass)
  def getTweet(query: String, twitter: Twitter): Unit = {
    val tweet = tweetObject.getTweet(query, twitter)
    val feedList = tweet.map((x) => x)

    feedList onComplete {
      case Success(feeds) => feeds foreach (f => log.info(f.getText))
      case Failure(ex) => log.info("Error getting feed " + ex.getMessage)
    }
  }
    def getCount(hashTag: String, twitter: Twitter): Unit ={
      val tweetObject = new Tweet
      val count = tweetObject.getTweetCount(hashTag, twitter)
      count onComplete {
        case Success(totalNumber) => log.info(s"\n\ntotal count $totalNumber\n\n")
        case Failure(ex) => log.info("Error getting feed " + ex.getMessage)
      }
    }
}
