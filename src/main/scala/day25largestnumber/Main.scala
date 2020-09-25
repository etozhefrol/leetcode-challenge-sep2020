package day25largestnumber

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]): Unit = {
    val ar = Array(1,1,1)
    Solution.largestNumber(ar)
  }
}

// AAGAGHAHAHAHAHAHHAHAHHAHAHAH
object Solution {
  def largestNumber(nums: Array[Int]): String = {
    @tailrec
    def compare(a: String, b: String): Boolean = {
      if (a(0) == b(0) && a.length + b.length > 2) {
        if (a.length < b.length) {
          compare(a.concat(a.last.toString).drop(1), b.drop(1))
        } else if (a.length > b.length) {
          compare(a.drop(1), b.concat(b.last.toString).drop(1))
        } else {
          compare(a.drop(1), b.drop(1))
        }
      } else a(0) >= b(0)
    }

    var res = nums
      .map(_.toString)
      .sortWith(compare)
      .mkString("")

    while (true) {
      if (res.startsWith("0") && res.length > 1) res = res.drop(1)
      else return res
    }

    "fail"
  }
}

// fastest
object Solution2 {
  def largestNumber(nums: Array[Int]): String = {
    var res = nums
      .map(_.toString)
      .sortWith((a, b) => BigDecimal(a.concat(b)) > BigDecimal(b.concat(a)))
      .mkString("")

    while (true) {
      if (res.startsWith("0") && res.length > 1) res = res.drop(1)
      else return res
    }

    "fail"
  }
}

object Solution3 {
  def largestNumber(nums: Array[Int]): String = {
    var res = nums
      .map(_.toString)
      .sortWith((a, b) => BigDecimal(a.concat(b)) > BigDecimal(b.concat(a)))
      .mkString("")

    BigDecimal(res).toString()
  }
}