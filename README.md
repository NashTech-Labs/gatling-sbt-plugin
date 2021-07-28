Gatling's SBT plugin demo

A simple project showing how to configure and use Gatling's SBT plugin to run Gatling simulations.

In this template, we have three simulation classes. 
For running a simulation with single injection profile, we have IndividualAPI class.
On the other hand, if we want a simulation with multiple injection profiles, we have MultipleScenarios class for that. 
lastly, we have Chaining class as well which showcases the chaining of multiple scenarios.


1) Clone the repository: Git clone https://github.com/knoldus/gatling-sbt-plugin.git
2) Checkout branch develop: git checkout feature/flow-sample-demo    
3) Go to working directory: cd gatling-sbt-plugin
4) Execute gatling test for chaining: sbt 'gatling:testOnly performanceTest.chaining'
5) Execute gatling test for individualAPI: sbt 'gatling:testOnly performanceTest.individualAPI'
6) Execute gatling test for multipleScenarios: sbt 'gatling:testOnly performanceTest.multipleScenarios'

Once test executed, a report can be found at the end of test execution.