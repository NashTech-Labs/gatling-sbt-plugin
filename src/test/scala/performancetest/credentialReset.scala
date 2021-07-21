package performancetest

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class credentialReset extends Simulation with TestSetup {
  //Info: Request Headers
  val httpProtocol: HttpProtocolBuilder = http // Here is the root for all relative URLs
    .header("accept", "application/json")
    .header("Content-Type", "application/json")

  val scn: ScenarioBuilder =
    scenario("Credential Reset")
      //Info: Need to create a csv for data driven
      //.feed(csv("/home/knoldus/Downloads/sectionAPIData-Sheet1.csv").circular)
      .exec(
        http("Credential_reset")
          // Here's an example of a POST request
          //Info: OCR engine url where we send the request
          .post("https://api-wip.tide.co/tide-backend/rest/api/v3/user-management/credential-resets")
          .body(StringBody("""{"email":"johnson.mike@tide.invalid"}""")).asJson
          //Info: test Data that we pass is request header as a form data
          .check(status in (200,204))
      )

  setUp(scn.inject(rampUsers(100).during(60)).protocols(httpProtocol))
}