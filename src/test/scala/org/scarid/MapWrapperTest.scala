package org.scarid

import org.scalatest.FunSuite
import org.scarid.collection.ScaridMap

/**
 * Created by fatihdonmez on 10/10/15
 */
class MapWrapperTest extends FunSuite {

  test("Simple map creation should work") {

    val expected = new ScaridMap[Int,String]("map1")

    ScaridMap("map1") match {
      case Some(result) => assertResult(expected)(result.asInstanceOf[ScaridMap[Int,String]])
      case None => fail("Map not found")
    }
  }

  test("Map should return all registered maps as expected") {

    val map2 = new ScaridMap[String,String]("map2")
    assertResult(2)(ScaridMap.getAll.length)
  }

  test("Map clear function should work as expected") {
    ScaridMap.clear
    assertResult(0)(ScaridMap.getAll.length)
  }
}
