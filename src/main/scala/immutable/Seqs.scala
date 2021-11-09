package com.abdulradi.benchmarks.scala3.collections.immutable

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.{BenchmarkParams, ThreadParams}
import scala.compiletime.uninitialized

// sbt> jmh:run -i 5 -wi 3 -f1 -t1 com.abdulradi.benchmarks.scala3.collections.immutable.Seqs
@State(Scope.Thread)
class Seqs:
  // O(1) no copying for head, tail and prepend, but O(n) for lookup by index and full-copying on append [Default Seq]
  var list: List[Int] = uninitialized 
  
  // eC for most of operations, plus minimal copying on tail or prepend
  var vector: Vector[Int] = uninitialized 

  @Setup
  def setup(params: BenchmarkParams): Unit =
    val data = Range(1, 9999999)
    list = data.toList
    vector = data.toVector

  @Benchmark // 3932489892.376 ± 14226066.696 ops/s
  def baseline = () // left blank to measure the overhead of the test setup

  @Benchmark // 1880972573.277 ± 76443399.375 ops/s
  def linkedListHead = list.head

  @Benchmark // 1559581157.814 ± 24457765.002 ops/s
  def vectorHead = vector.head

  @Benchmark // 
  def linkedListTail = list.tail

  @Benchmark // 1559581157.814 ± 24457765.002 ops/s
  def vectorTail = vector.tail

  @Benchmark // 21.883 ± 0.353 ops/s
  def linkedListLast = list.last

  @Benchmark // 981250806.986 ± 12478629.510 ops/s
  def vectorLast = vector.last

  @Benchmark // 12.473 ± 0.525 ops/s
  def linkedListConcat = list ++ list

  @Benchmark // 38.532 ± 0.241 ops/s
  def vectorConcat = vector ++ vector

  @Benchmark // 3.570 ± 1.215  ops/s
  def listMap = list.map(_ + 1)

  @Benchmark // 14.762 ± 0.534  ops/s
  def vectorMap = vector.map(_ + 1)

  @Benchmark //
  def listAppend = list.appended(0)

  @Benchmark //
  def vectorAppend = vector.appended(0)

  @Benchmark //
  def listPrepend = list.prepended(0)

  @Benchmark //
  def vectorPrepend = vector.prepended(0)