package day24findthedifference

object Solution {
  def findTheDifference(s: String, t: String): Char = {
    val ar: Array[Int] = Array.fill('z'.toInt + 1 - 'a'.toInt)(0)

    for (letter <- s) ar(letter.toInt - 'a'.toInt) += 1

    for (letter <- t) {
      ar(letter.toInt - 'a'.toInt) -= 1
      if (ar(letter.toInt - 'a'.toInt) < 0) {
        return letter
      }
    }

    'A'
  }
}

// slower
object Solution2 {
  def findTheDifference(s: String, t: String): Char = (t.sum - s.sum).toChar
}