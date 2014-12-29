package com.scarid.core.server

import java.net.{Socket,ServerSocket}
import java.util.concurrent.{Executors,ExecutorService}

class ScaridServer(port:Int, poolSize:Int )  {

  private val serverSocket = new ServerSocket(port)
  private val pool = Executors.newFixedThreadPool(poolSize)

  def start() {

    try {
      while (true) {

        val clientSocket = serverSocket.accept()
        pool.execute(new ClientHandler(clientSocket))
      }
    }
    finally {
      pool.shutdown()
    }

  }

}
