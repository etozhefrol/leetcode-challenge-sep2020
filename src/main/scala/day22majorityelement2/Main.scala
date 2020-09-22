package day22majorityelement2

object Solution {
  def majorityElement(nums: Array[Int]): List[Int] = {
    var res: List[Int] = List()

    var firstNum = Int.MinValue
    var secondNum = Int.MinValue

    var firstCounter = 0
    var secondCounter = 0

    for (i <- nums) {
      if (i.equals(firstNum)) {
        firstCounter += 1
      } else if (i.equals(secondNum)) {
        secondCounter += 1
      } else if (firstCounter.equals(0)) {
        firstNum = i
        firstCounter += 1
      } else if (secondCounter.equals(0)) {
        secondNum = i
        secondCounter += 1
      } else {
        firstCounter -= 1
        secondCounter -= 1
      }
    }

    if (nums.count(_ == firstNum) > nums.length / 3) res = res :+ firstNum
    if (nums.count(_ == secondNum) > nums.length / 3 && secondNum != Int.MinValue) res = res :+ secondNum

    res
  }
}
