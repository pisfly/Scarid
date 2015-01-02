package com.scarid.client

object ClientTester {

  def main (args: Array[String]) {

    val instance = new ScaridClientInstance("127.0.0.1",4343)

    //instance.set("username","pelin")
    val data = instance.get("username")

    println(data)

  }
}
