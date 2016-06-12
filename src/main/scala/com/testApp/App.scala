package com.testApp

import java.nio.file.Paths

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object App {
  def main(args: Array[String]): Unit = {
    val workDirectory = getWorkDirectory()
    val inputFile = Paths.get(workDirectory, "pom.xml").toString

    val conf = new SparkConf()
      .setAppName("Simple Application")
      .setMaster("local[4]")

    val sc = new SparkContext(conf)
    val logData = sc.textFile(inputFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))

    System.in.read()
  }

  def getWorkDirectory(): String = {
    Paths.get(".").toAbsolutePath.normalize().toString
  }
}
