package org.scarid

import java.util.concurrent.{ConcurrentMap, ConcurrentHashMap}
import org.scarid.collection.ScaridMap

/**
 * Created by fatihdonmez on 10/10/15
 */
protected object Scarid {

  private val  maps: ConcurrentMap[String, ScaridMap[Any,Any]] = new ConcurrentHashMap[String, ScaridMap[Any,Any]]()

  def get(name: String): Option[ScaridMap[Any,Any]] = Option(maps.get(name))

  def getAll: List[ScaridMap[Any,Any]] = maps.values.toArray().toList.asInstanceOf[List[ScaridMap[Any,Any]]]

  def register(name: String, map: ScaridMap[Any,Any]): Unit  = {
    maps.put(name,map)
  }

  def clear = maps.clear
}
