case class PathList(paths: Path*) {
  def shortestPathWithStopAt(stop: Point) = withStopAt(stop).shortestPath

  def withStopAt(stop: Point) = PathList(paths.filter(_.hasStop(stop)):_*)

  def shortestPath = paths.minBy(path => path.distance)
}
