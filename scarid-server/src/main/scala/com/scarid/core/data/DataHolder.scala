package com.scarid.core.data

import com.scarid.common.data.DataPair

import scala.collection.mutable

object DataHolder{

  private val raw = new mutable.HashMap[String,Any]()

  def set(pair:DataPair) = {
    raw.synchronized {
      raw.update(pair.key, pair.value)
    }

  }

  def get(key:String):DataPair = {
    new DataPair(key,raw.get(key))
  }
}
