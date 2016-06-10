package com.testApp

object App {
  def main(args: Array[String]): Unit =
    AppArguments.parse(args) match {
      case None =>
        displayUsage()
      case Some(appArguments) if appArguments.help =>
        displayUsage()
      case Some(appArguments) =>
        println("RunApp: TODO")
    }

  private def displayUsage(): Unit = {
    println("Usage: TODO")
  }

  private def waitEnterKey(): Unit = {
    val NEWLINE = '\n'.toInt
    while (System.in.read != NEWLINE) {
      Thread.sleep(1000)
    }
  }
}
