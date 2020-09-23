package day23gasstation

object Solution {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    var startInd = 0
    var tank = 0
    var shortage = 0

    for (i <- cost.indices) {
      tank += gas(i)

      if (tank >= cost(i)) {
        tank -= cost(i)
      } else {
        shortage += cost(i) - tank
        startInd = i + 1
        tank = 0
      }
    }

    if (startInd == gas.length || tank < shortage) -1
    else startInd
  }
}
