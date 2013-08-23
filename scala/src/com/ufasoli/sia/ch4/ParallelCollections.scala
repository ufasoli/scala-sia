package com.ufasoli.sia.ch4

import scala.collection.parallel.immutable.ParVector

/**
 *
 * User: ufasoli
 * Date: 23/08/13
 * Time: 15:36
 * project : scala-sia
 */
class ParallelCollections {


  def parallelCollection() {
    println("****************************")
    println("Parallel Collections")
    println("****************************")

    println("Runing map on Parallel Vector")
    val mapped = ParVector(10, 20, 30, 40, 50, 60, 70, 80, 90).map {
      x =>
        println(Thread.currentThread.getName); x / 2

    }

    println(mapped)


    println("Sometimes a parallel collection will be executed sequentially no matter what")

   val result =  ParVector(10, 20, 30, 40, 50, 60, 70, 80, 90).foldLeft(0) {(a,x) =>
      println(Thread.currentThread.getName); a+x}

    println(result)
    println("****************************")
    println("END Parallel Collections")
    println("****************************")
  }

  def fromSeqToParallel(){
    println("****************************")
    println("fromSeqToParallel")
    println("****************************")

    println("You can sometimes run  parallel operations on a sequential collection")

    val vs = Vector.range(1, 10000)
    println(vs.par.filter({_ % 2 == 0}))


    println("Back to sequential")
    println(vs.par.filter({_ % 2 == 0}).seq)
    println("****************************")
    println("END fromSeqToParallel")
    println("****************************")



  }
}
