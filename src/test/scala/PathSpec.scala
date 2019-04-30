import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class PathSpec extends FlatSpec with Matchers {

  class CleanContext extends PathFixtures {}

  "a path" should "with two segments returns the distance" in new CleanContext {
    val path = new Path(List(ab, bc), List(pa))

    path.distance shouldBe 28.2842 +- DoublePrecision
  }

  "a path" should "with four segments returns the distance" in new CleanContext {
    val path = new Path(List(ab, bc, cd, de), List(pa))

    path.distance shouldBe 48.2842 +- DoublePrecision
  }

  "a path" should "has the stop a" in new CleanContext {
    val path = new Path(List(ab, bc, cd, de), List(pa))

    path.hasStop(pa) shouldBe true
  }

  "a path" should "has not the stop a" in new CleanContext {
    val path = new Path(List(ab, bc, cd, de), List(pb))

    path.hasStop(pa) shouldBe false
  }
}