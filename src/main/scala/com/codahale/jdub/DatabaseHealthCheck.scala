package com.codahale.jdub

import com.yammer.metrics.core.HealthCheck
import com.yammer.metrics.core.HealthCheck.Result

class DatabaseHealthCheck(val database: Database) extends HealthCheck {
  def name() = "database"

  def check() = if (database.ping()) {
    Result.healthy()
  } else {
    Result.unhealthy("1 wasn't equal to 1")
  }
}
