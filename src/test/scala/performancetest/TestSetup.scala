package performancetest

import java.io.{File, FileWriter, PrintWriter}

trait TestSetup {

  val purchaseRequests = "12NovTestBed2UUID.csv"
  val fleetHereApi = "https://fleet.api.here.com"
  val bingeSnapToRoadApi = "http://dev.virtualearth.net/REST"
  val stagingUrlOcr= "http://35.155.45.104:8031"

  def purchaseWrite(purchaseJson: Map[String, String]): Unit = {
    val fileAlreadyExist = new File(purchaseRequests).exists()
    try {
      val purchaseWriter = new PrintWriter(new FileWriter(purchaseRequests, true))
      if (fileAlreadyExist == false) {
        purchaseWriter.append(purchaseJson + "\n")
        purchaseWriter.close()
      } else {
        purchaseWriter.append(purchaseJson + "\n")
        purchaseWriter.close()
      }
    } catch {
      case ex: Exception => println("oops...")
    }
  }

  def purchaseReceiptUuidWrite(purchaseJson: Map[String, String]): Unit = {
    val fileAlreadyExist = new File(purchaseRequests).exists()
    try {
      val purchaseWriter = new PrintWriter(new FileWriter(purchaseRequests, true))
      if (fileAlreadyExist == false) {
        purchaseWriter.append(purchaseJson + "\n")
        purchaseWriter.close()
      } else {
        purchaseWriter.append(purchaseJson + "\n")
        purchaseWriter.close()
      }
    } catch {
      case ex: Exception => println("oops...")
    }
  }
}
