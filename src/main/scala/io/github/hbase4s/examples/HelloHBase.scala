package io.github.hbase4s.examples

import io.github.hbase4s.config.HBasePropsConfig
import io.github.hbase4s.{HBaseClient, HBaseConnection}

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
  val client: HBaseClient = new HBaseClient(new HBaseConnection(new HBasePropsConfig(props)), "transactions")

  case class Event(id: Int, desc: String, enabled: Boolean)

  client.put("id_12", Event(15, "some", true))

}
