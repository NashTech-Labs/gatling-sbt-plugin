package performanceTest

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

/**
 * galting test for Demo API's .
 */

/**
* This test include the test cases for the individual API's and asseting on the status codes
* and on response attributes.
 */

class individualAPI extends Simulation {

  val url: String = "https://reqres.in/api/users?page=2"
  val users: Int = 100
  val OK = 200

  def createScenarioBuilder(scenarioName: String, requestName: String, path: String, pauseDuration: Int): ScenarioBuilder = {
    /**
     * generic method for creating a scenario
     */
    val scene: ScenarioBuilder = scenario(scenarioName) // creating the scenario on which simulation will happen.
      .exec(http(requestName)
        .get(url).check(status.is(OK)) // status code assertion
        .check(jsonPath(path).findAll))// asserting JSON
      .pause(pauseDuration)
    scene
  }

  def setUp(): Unit = {
    /**
     * to set up the scenario and to inject the number of users.
     */
    val scenarioBuilder = createScenarioBuilder("Sample api test", "IndividualRequest", "$..page", 1)
    val httpProtocol: HttpProtocolBuilder = http.baseUrl(url)
    // setting up injection profile to simulate the number of users
    // who will simultaneously access the API.
    setUp(scenarioBuilder.inject(atOnceUsers(users)).protocols(httpProtocol))
  }
  setUp()
}