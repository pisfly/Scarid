package com.scarid.core.server

import java.io._
import java.net.Socket
import com.scarid.common.{SetCommand,GetCommand}
import com.scarid.core.data._
import com.scarid.common.data._

//TODO implement generic ClientHandler interfaces for internal nodes, external clients
class ClientHandler(socket:Socket) extends Runnable{

  override def run() {

    val objectInputStream = new ObjectInputStream(socket.getInputStream)
    val objectOutputStream = new ObjectOutputStream(socket.getOutputStream)

    println("Client:" + socket.getInetAddress.getHostName)

    try {

      while (true) {

        val cmd = objectInputStream.readObject()

        cmd match {

          case SetCommand(data) => {
            println("Command:Set")
            println("Key:" + data.key)
            println("Value:" + data.value.toString)
            DataHolder.set(data)
          }
          case GetCommand(key) => {
            println("Command:Get")
            println("Key:" + key)

            val data = DataHolder.get(key)
            println(data)
            objectOutputStream.writeObject(data)
            objectOutputStream.flush()

          }
        }
      }
    }
    catch{
      case e:EOFException => println("Client Disconnected:" + socket.getInetAddress.getHostName)
      case e:Exception => println(e)
    }
    finally {
      println("Finally run is over")
      socket.close()
    }

  }
}