import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SegmentSpec extends FlatSpec with Matchers {

  class CleanContext extends PathFixtures {}

  "a segment" should "compute its distance" in new CleanContext {
    ac.distance shouldBe 20.0 +- 0.0001
  }
}