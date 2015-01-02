package com.scarid.client

import java.io.{ObjectInputStream, ObjectOutputStream}
import java.net.{Socket}
import com.scarid.common.{Command,SetCommand,GetCommand}
import com.scarid.common.data._

class ScaridClientInstance(host:String,port:Int) {

  private val socket = new Socket(host,port)
  private val objectStream = new ObjectOutputStream(socket.getOutputStream)

  /**
   * Set a value on servers with the given key
   * @param key
   * @param value
   */
  def set(key:String,value:Any): Unit = {

    val data = new DataPair(key,value)
    val command = new SetCommand(data)

    runCommand(command)

  }

  /**
   * Get item for the given key
   * @param key
   * @return
   */
  def get(key:String): Any = {

    val command = new GetCommand(key)
    runCommand(command)

    val inputStream = new ObjectInputStream(socket.getInputStream)
    val data = inputStream.readObject() match {

      case DataPair(key,value) => value
      case _ => None

    }

    data
  }

  private def runCommand(command:Command): Unit = {
    objectStream.writeObject(command)
    objectStream.flush()
  }


}
