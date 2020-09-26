package day26teemoatacking

object Main {

}

object Solution {
  def findPoisonedDuration(timeSeries: Array[Int], duration: Int): Int = {
    if (timeSeries.isEmpty) 0
    else if (timeSeries.length == 1) duration
    else {
      var result: Int = duration

      for (i <- 1 until timeSeries.length) {
        if (timeSeries(i) - timeSeries(i - 1) >= duration) {
          result += duration
        } else {
          result += timeSeries(i) - timeSeries(i - 1)
        }
      }

      result
    }
  }
}