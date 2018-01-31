package edu.knoldus.operation

import twitter4j.{Query, Status, Twitter}

import scala.collection.JavaConversions._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future



class Tweet {

  def getTweet(hashTag: String, twitter: Twitter): Future[List[Status]] = Future  {
    val query = new Query(hashTag)
    val result = twitter.search(query)
    val status = result.getTweets
    status.toList
  }

  def getTweetCount(hashTag: String, twitter: Twitter): Future[Int] = Future {
    val query = new Query(hashTag)
    val result = twitter.search(query)
    result.getTweets.size
  }

}
