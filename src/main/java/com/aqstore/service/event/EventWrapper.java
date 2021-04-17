package com.aqstore.service.event;

import java.time.Instant;
import java.util.UUID;

import org.springframework.util.Assert;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EventWrapper<ID,PAYLOAD extends EventPayload<ID>> {

	private String eventId = UUID.randomUUID().toString();
	private final String topic;
	private final PAYLOAD payload;
	Instant createdAt = Instant.now();
	
	
	
	public String getPayloadId() {
		Assert.notNull(payload.getPayloadId(),"Id of payload must not be null");
		return payload.getPayloadId().toString();
	}
	


}
