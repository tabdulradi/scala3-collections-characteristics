package com.abdulradi.benchmarks.scala3.collections.mutable

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.{BenchmarkParams, ThreadParams}
import scala.compiletime.uninitialized
import scala.collection.immutable.*

// sbt> jmh:run -i 5 -wi 3 -f1 -t1 com.abdulradi.benchmarks.scala3.collections.immutable.Sets
@State(Scope.Thread)
class Sets:
  var hashSet: HashSet[Int] = uninitialized // O(1) .contains(), no order gurantees
  var treeSet: TreeSet[Int] = uninitialized // O(log n) and Sorted
  var listSet: ListSet[Int] = uninitialized // O(n) .contains(), Perserves Order

  var existingElement: Int = uninitialized
  var nonExistingElement: Int = uninitialized

  @Setup
  def setup(params: BenchmarkParams): Unit =
    val data = scala.util.Random.alphanumeric.map(_.toInt).take(99999).toArray
    hashSet = HashSet.from(data)
    treeSet = TreeSet.from(data)
    listSet = ListSet.from(data) // Struggles with bigger size
    existingElement = data(5000000)
    nonExistingElement = '@' // outside alphanumeric range

  @Benchmark // 
  def baseline = () // left blank to measure the overhead of the test setup

  @Benchmark // 
  def hashSetContainsExisting = hashSet.contains(existingElement)

  @Benchmark // 
  def treeSetContainsExisting = treeSet.contains(existingElement)

  @Benchmark // 
  def listSetContainsExisting = listSet.contains(existingElement)

  @Benchmark // 
  def hashSetContainsNonExisting = hashSet.contains(nonExistingElement)

  @Benchmark // 
  def treeSetContainsNonExisting = treeSet.contains(nonExistingElement)

  @Benchmark // 
  def listSetContainsNonExisting = listSet.contains(nonExistingElement)

  @Benchmark // 
  def hashSetConcat = hashSet ++ hashSet

  @Benchmark // 
  def treeSetConcat = treeSet ++ treeSet

  @Benchmark // 
  def listSetConcat = listSet ++ listSet

  @Benchmark // 
  def hashSetAdd = hashSet + nonExistingElement

  @Benchmark // 
  def treeSetAdd = treeSet + nonExistingElement

  @Benchmark // 
  def listSetAdd = listSet + nonExistingElement

  @Benchmark // 
  def hashSetRemove = hashSet - existingElement

  @Benchmark // 
  def treeSetRemove = treeSet - existingElement

  @Benchmark // 
  def listSetRemove = listSet - existingElement