import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class PathListSpec extends FlatSpec with Matchers {

  class CleanContext extends PathFixtures {}

  "a pathlist" should "return the shortest path from a to c" in new CleanContext {
    val path1 = new Path(List(ab, bc), List(pb))
    val path2 = new Path(List(ac), List(pb))

    val pathList = PathList(path1, path2)
    pathList.shortestPath shouldBe path2
  }

  "a pathlist" should "return the shortest path from a to e" in new CleanContext {
    val path1 = new Path(List(ac, cd, de), List(pb))
    val path2 = new Path(List(ab, bc, cd, de), List(pb))

    val pathList = PathList(path1, path2)
    pathList.shortestPath shouldBe path1
  }

  "a pathlist" should "filter the paths with a stop in c" in new CleanContext {
    val path1 = new Path(List(ab, cd, de), List(pb))
    val path2 = new Path(List(ab), List(pc))
    val path3 = new Path(List(ab, bc), List(pc))

    val pathList = PathList(path1, path2, path3)
    pathList.withStopAt(pc) shouldBe PathList(path2, path3)
  }

  "a pathlist" should "return empty list if no paths with stops" in  new CleanContext {
    val pathlist = PathList(new Path(List(), List()))

    pathlist.withStopAt(pc) shouldBe PathList()
  }

  "a pathlist" should "return the shortest path from a to c which includes a stop in c" in new CleanContext {
    val path1 = new Path(List(ab), List(pb))
    val path2 = new Path(List(ab, bc, cd), List(pc))
    val path3 = new Path(List(ac, cd), List(pc))

    val pathList = PathList(path1, path2, path3)
    pathList.shortestPathWithStopAt(pc) shouldBe path3
  }
}
