package com.nlgtuankiet.fera.domain.gateway

import org.threeten.bp.Instant
import org.threeten.bp.ZoneOffset

interface TimeGateway {
  fun now(): Instant
  fun zoneOffset(): ZoneOffset
}
