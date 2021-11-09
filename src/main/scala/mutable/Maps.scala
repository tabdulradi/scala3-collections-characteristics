package com.abdulradi.benchmarks.scala3.collections.mutable

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.{BenchmarkParams, ThreadParams}
import scala.compiletime.uninitialized
import scala.collection.immutable.*

// sbt> jmh:run -i 5 -wi 3 -f1 -t1 com.abdulradi.benchmarks.scala3.collections.immutable.Maps
@State(Scope.Thread)
class Maps:
  var hashMap: HashMap[Int, String] = uninitialized // O(1) .contains(), no order gurantees
  var treeMap: TreeMap[Int, String] = uninitialized // O(log n) and Sorted
  var listMap: ListMap[Int, String] = uninitialized // O(n) .contains(), Perserves Order

  var existingKey: Int = uninitialized
  var nonExistingKey: Int = uninitialized

  @Setup
  def setup(params: BenchmarkParams): Unit =
    val data = scala.util.Random.alphanumeric.map(x => x.toInt -> x.toString).take(9999999).toArray
    hashMap = HashMap.from(data)
    treeMap = TreeMap.from(data)
    listMap = ListMap.from(data)
    existingKey = data(5000000)._1
    nonExistingKey = '@' // outside alphanumeric range

  @Benchmark // 
  def baseline = () // left blank to measure the overhead of the test setup

  @Benchmark // 
  def hashMapContainsExisting = hashMap.contains(existingKey)

  @Benchmark // 
  def treeMapContainsExisting = treeMap.contains(existingKey)

  @Benchmark // 
  def listMapContainsExisting = listMap.contains(existingKey)

  @Benchmark // 
  def hashMapContainsNonExisting = hashMap.contains(nonExistingKey)

  @Benchmark // 
  def treeMapContainsNonExisting = treeMap.contains(nonExistingKey)

  @Benchmark // 
  def listMapContainsNonExisting = listMap.contains(nonExistingKey)

  @Benchmark // 
  def hashMapConcat = hashMap ++ hashMap

  @Benchmark // 
  def treeMapConcat = treeMap ++ treeMap

  @Benchmark // 
  def listMapConcat = listMap ++ listMap

  @Benchmark // 
  def hashMapAdd = hashMap + (nonExistingKey -> "")

  @Benchmark // 
  def treeMapAdd = treeMap + (nonExistingKey -> "")

  @Benchmark // 
  def listMapAdd = listMap + (nonExistingKey -> "")

  @Benchmark // 
  def hashMapRemove = hashMap - existingKey

  @Benchmark // 
  def treeMapRemove = treeMap - existingKey

  @Benchmark // 
  def listMapRemove = listMap - existingKey