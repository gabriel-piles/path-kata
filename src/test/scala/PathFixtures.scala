class PathFixtures {
  val pa = Point("a", 0, 0)
  val pb = Point("b", 10, 10)
  val pc = Point("c", 20, 0)
  val pd = Point("d", 30, 0)
  val pe = Point("e", 40, 0)

  val ac = Segment(pa, pc)
  val bc = Segment(pb, pc)
  val ab = Segment(pa, pb)
  val cd = Segment(pc, pd)
  val de = Segment(pd, pe)

  val DoublePrecision = 0.0001
}
