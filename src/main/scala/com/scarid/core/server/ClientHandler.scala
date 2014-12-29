package com.scarid.core.server

import java.io.{InputStreamReader, BufferedReader, ObjectInputStream}
import java.net.Socket

//TODO implement generic ClientHandler interfaces for internal nodes, external clients
class ClientHandler(socket:Socket) extends Runnable{

  def run() {

    socket.getOutputStream.write("Hello scarid".getBytes)
    val bf = new BufferedReader(new InputStreamReader(socket.getInputStream))

    println("Client:" + socket.getInetAddress.getHostName)

    var msg = ""
    while({ msg = bf.readLine(); msg != null }){
      println("Data:" + msg)
    }

  }
}
