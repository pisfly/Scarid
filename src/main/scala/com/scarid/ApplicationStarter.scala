package com.scarid

import core.server.ScaridServer

object ApplicationStarter {

  def main (args: Array[String]): Unit = {

    println("Server started")

    val instance = new ScaridServer(4343,100)
    instance.start

  }

}
