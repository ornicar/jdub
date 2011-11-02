package com.codahale.jdub

import scala.annotation.tailrec
import java.sql.{Types, PreparedStatement, Timestamp}

object Utils {
  private[jdub] def prependComment(obj: Object, sql: String) =
    "/* %s */ %s".format(obj.getClass.getSimpleName.replace("$", ""), sql)

  @tailrec
  private[jdub] def prepare(stmt: PreparedStatement, values: Seq[Any], index: Int = 1) {
    if (!values.isEmpty) {
      values.head match {
        case null =>
          stmt.setNull(index, Types.NULL)
        case s: String =>
          stmt.setString(index, s)
        case l: Long =>
          stmt.setLong(index, l)
        case i: Int =>
          stmt.setInt(index, i)
        case b: Array[Byte] =>
          stmt.setBytes(index, b)
        case b: Boolean =>
          stmt.setBoolean(index, b)
        case d: Double =>
          stmt.setDouble(index, d)
        case t: Timestamp =>
          stmt.setTimestamp(index, t)
        case v =>
          stmt.setObject(index, v.asInstanceOf[AnyRef])
      }
      prepare(stmt, values.tail, index + 1)
    }
  }
}
