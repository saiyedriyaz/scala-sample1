
object ExecutionTimeCalculator {
  def main(args: Array[String]): Unit = {
    if (args != null && !args.isEmpty) {
      val jobs = getDefaultInput()
      try {
        val calculated = calculateJobTime(args(0).toInt, jobs)
        println("total execution time = {} for job id {}", calculated, args(0).toInt)
      } catch {
        case s: NumberFormatException => println("Invalid Id provided.")
      }
    }
  }

  case class Job(id: Int, jobTime: Int, childJobIDs: Array[Int])

  def calculateJobTime(id: Int, jobs: Array[Job]): Int = {
    var calculatedTime = 0
    jobs.map(job => {
      if (id == job.id) {
        calculatedTime = calculatedTime + job.jobTime
        if (!job.childJobIDs.isEmpty) {
          job.childJobIDs.map(cId => {
            if (id == cId) {
              throw new IllegalArgumentException("Cyclic Job Found")
            }
            calculatedTime = calculatedTime + calculateJobTime(cId, jobs)
          })
        }
      }
    })
    calculatedTime
  }

  def getDefaultInput(): Array[Job] = {
    Array(
      Job(1, 30, Array(2, 4)),
      Job(2, 10, Array(3)),
      Job(4, 60, Array()),
      Job(3, 20, Array())
    )
  }
}