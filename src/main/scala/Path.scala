class Path(segments: List[Segment], stops: List[Point]) {
  def hasStop(stop: Point): Boolean = stops.contains(stop)

  def distance = segments map (_.distance) sum
}

