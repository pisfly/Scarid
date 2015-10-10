package org.scarid.collection

import org.scarid.Scarid
import scala.collection._

/**
 * Created by fatihdonmez on 10/10/15
 */
class ScaridMap[K, V](val name: String) extends mutable.Map[K, V] {

  Scarid.register(name,this.asInstanceOf[ScaridMap[Any,Any]])

  override def +=(kv: (K, V)): ScaridMap.this.type = ???

  override def -=(key: K): ScaridMap.this.type = ???

  override def get(key: K): Option[V] = ???

  override def iterator: scala.Iterator[(K, V)] = ???
}

object ScaridMap {

  def apply(name: String): Option[ScaridMap[Any,Any]] = Scarid.get(name)

  def getAll: List[ScaridMap[Any,Any]] = Scarid.getAll

  def clear = Scarid.clear
}
