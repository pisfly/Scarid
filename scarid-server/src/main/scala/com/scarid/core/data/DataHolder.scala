package com.scarid.core.data

import com.scarid.common.data.DataPair

import scala.collection.mutable

object DataHolder{

  private val raw = new mutable.HashMap[String,Any]()

  //TODO make it thread safe
  def set(pair:DataPair) = {
      raw.update(pair.key,pair.value)

  }

  def get(key:String):DataPair = {
    new DataPair(key,raw.get(key))
  }
}
