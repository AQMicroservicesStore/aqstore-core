package com.aqstore.service.event.payload;

import java.time.Instant;
import java.util.UUID;

import com.aqstore.service.event.EventType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractBaseEvent implements EventPayload{

	private EventType eventType;
	@Builder.Default
	private String eventId = UUID.randomUUID().toString();
	@Builder.Default
	private Instant eventCreationTimestamp = Instant.now();
	
}
