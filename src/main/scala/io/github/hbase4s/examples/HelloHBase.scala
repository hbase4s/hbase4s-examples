package io.github.hbase4s.examples

import io.github.hbase4s.config.HBasePropsConfig
import io.github.hbase4s.{HBaseClient, HBaseConnection}
import io.github.hbase4s.filter._

/**
  * Example 1
  * Connect to HBase using hbase4s
  * Store some data
  * Retrieve data by key
  * Retrieve data by different filters
  * Remove data
  * Created by Volodymyr.Glushak on 02/06/2017.
  */
object HelloHBase extends App {

  val props = Map("hbase.zookeeper.quorum" -> "localhost")
  val transactions: HBaseClient = new HBaseClient(new HBaseConnection(new HBasePropsConfig(props)), "transactions")

  case class Event(uniqueId: Long, amount: Double, buyer: String, payer: String, date: String, completed: Boolean)


  private val ev = Event(15L, 150000d, "goldman", "china", "2018/01/01", true)

  println("Insert record to HBase")
  transactions.put(ev.uniqueId, ev)

  println("Retrieving record from HBase by Id")
  val storedEvent = transactions.get(15L).map(_.typed[Event].asClass)

  require(Some(ev) == storedEvent)

  println("Query all transactions for particular buyer with amount greater than 100k")
  val foundTransactions = transactions.scan[Long](
    "(event:buyer == goldman) AND (event:amount > double(100000))"
  ).map(_.typed[Event].asClass).toList

  require(foundTransactions.size == 1)
  require(foundTransactions == List(ev))

  println("Same filter with different static DSL")
  val foundTransactions2 = transactions.scan[Long](
    c("event", "buyer") === "goldman" & c("event", "amount") > 100000.0
  ).map(_.typed[Event].asClass).toList

  require(foundTransactions2.size == 1)
  require(foundTransactions2 == List(ev))

  println("Drop our transaction from HBase")
  transactions.delete(15L)
}
