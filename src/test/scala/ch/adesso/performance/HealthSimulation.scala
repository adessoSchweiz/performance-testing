package ch.adesso.performance

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class HealthSimulation extends Simulation {
  before {
    println("***** My simulation is about to begin! *****")
  }

  after {
    println("***** My simulation has ended! ******")
  }

  val theHttpProtocolBuilder = http
    .baseURL("http://http://18.184.209.28:31000")

  val theScenarioBuilder = scenario("Calling Health Point")
    .exec(
      http("health")
        .get("/trunk-based/resources/health")
    )
    .pause(1)

  setUp(
    theScenarioBuilder.inject(rampUsersPerSec(10).to(20).during(10))
  ).protocols(theHttpProtocolBuilder)
    .constantPauses
}
