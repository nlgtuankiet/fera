package com.nlgtuankiet.fera.data

import com.nlgtuankiet.fera.domain.gateway.TimeGateway
import org.threeten.bp.Instant
import org.threeten.bp.ZoneOffset
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
// TODO implement get time from remote source
// TODO implement get off set from device
class TimeGatewayImpl @Inject constructor() : TimeGateway {
  override fun now(): Instant {
    return Instant.now()
  }

  override fun zoneOffset(): ZoneOffset {
    return ZoneOffset.ofHours(7)
  }
}
