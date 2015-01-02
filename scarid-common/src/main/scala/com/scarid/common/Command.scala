package com.scarid.common

import com.scarid.common.data.DataPair

abstract class Command
case class SetCommand(data:DataPair) extends Command
case class GetCommand(key:String) extends Command
