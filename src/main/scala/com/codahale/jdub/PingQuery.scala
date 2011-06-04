package com.codahale.jdub

/**
 * A simple query which returns {@code true} if the server can process a simple
 * query ({@code SELECT 1}) which doesn't touch any tables or anything.
 */
object PingQuery extends Query[Boolean] {
  val sql = "SELECT 1"

  val values = Nil

  def reduce(results: Vector[Vector[Any]]) = results == Vector(Vector(1))
}
