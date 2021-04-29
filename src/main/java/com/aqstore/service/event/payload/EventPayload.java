package com.aqstore.service.event.payload;

import java.time.Instant;

import com.aqstore.service.event.EventType;

public interface EventPayload {
	
	
	public EventType getEventType();
	public String getEventId();
	public Instant getEventCreationTimestamp();
	public String getPayloadId();



}
