package edu.knoldus.operation

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.collection.JavaConversions._
import twitter4j.{Query, QueryResult, Status, Twitter}


class Tweet {

  def getTweet(hashTag: String, twitter: Twitter): Future[List[Status]] = Future  {
    val count =100
    val query = new Query(hashTag)
    query.setCount(count)
    val result = twitter.search(query)
    val status = result.getTweets
    status.toList
  }

  def getTweetCount(hashTag: String, twitter: Twitter): Future[Int] = Future {
    val count =100
    val query = new Query(hashTag)
    query.setCount(count)
    val result = twitter.search(query)
    result.getTweets.size
  }


  def getTweetByTime(hashTag: String, since: String, twitter: Twitter): Future[Int] = Future {
    val count =100
    val query = new Query(hashTag)
    query.setSince(since)
    query.setCount(count)
    query.setUntil("2018-02-01")
    val result = twitter.search(query)
    val total = result.getTweets.size
    print("\n\nTotal" + total + "\n\n")
    val averageDate = total / 3
    averageDate
  }

  def getFavoriteTweet(twitter: Twitter): Future[Int] = Future {
    val userId =  254136345L
    val favoriteTweet = twitter.getFavorites(userId)
    val total = favoriteTweet.size
    print("\n\nTotal" + total + "\n\n")
    total / 2
  }
}