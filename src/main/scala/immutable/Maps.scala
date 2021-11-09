package com.abdulradi.benchmarks.scala3.collections.immutable

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

  @Benchmark // 110460075.163 ±   3216072.220  ops/s
  def hashMapContainsExisting = hashMap.contains(existingKey)

  @Benchmark // 10129332.230 ±     48128.079  ops/s
  def treeMapContainsExisting = treeMap.contains(existingKey)

  @Benchmark // 7553890.215 ±    142642.847  ops/s
  def listMapContainsExisting = listMap.contains(existingKey)

  @Benchmark // 201810104.912 ±   9049003.533  ops/s
  def hashMapContainsNonExisting = hashMap.contains(nonExistingKey)

  @Benchmark // 6474847.700 ±    272383.857  ops/s
  def treeMapContainsNonExisting = treeMap.contains(nonExistingKey)

  @Benchmark // 1838567.728 ±     57827.945  ops/s
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