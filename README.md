# luxoft-assignment
This solution is define in Scala and uses SBT to build and run.

Follow below link to download and install sbt
https://www.scala-sbt.org/download.html

Command to execute solution with sample data is: ~run <jobid>
For example, in order to find the execution time fo job id 2, run command "~run 2"

Command to execute the test cases is: ~test

############################################
# Problem Statement
// Given a job struct definition below write a function that takes 2 inputs:
// * ID of a job to run
// * a slice/array/list of known job descriptions
// and return a total execution time of job with ID=ID and all of its
children
// recursively.
//
// We can assume that there are no cycles in the dependency graph and job
// descriptions in the slice/array/list are unique i.e. there are no
duplicates.
//
// Add a couple of tests to prove your solution.
// Use whatever language you feel most comfortable with but please include
// instructions on how to compile it and run the tests.
//
// For the exemplar 'jobs' slice below:
// * given ID=4 the function should return 60 - just a single job's duration
// without any dependencies
// * given ID=2 the function should return 30 - duration of jobs 2 and 3
// * given ID=1 the function should return 120 - duration of jobs 1, 2, 3
and 4

type Job struct {
ID int
jobTime int
childJobIDs []int
}

var jobs = []Job{
Job{1, 30, []int{2, 4}},
Job{2, 10, []int{3}},
Job{4, 60, []int{}},
Job{3, 20, []int{}},
}
