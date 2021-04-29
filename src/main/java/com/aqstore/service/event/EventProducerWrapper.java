package com.aqstore.service.event;

import org.springframework.util.Assert;

import com.aqstore.service.event.payload.EventPayload;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EventProducerWrapper<PAYLOAD extends EventPayload> {

	private final String topic;
	private final PAYLOAD payload;

	public String getPayloadId() {
		Assert.notNull(payload.getPayloadId(),"Id of payload must not be null");
		return payload.getPayloadId();

	}
	
	public String getEventId() {
		Assert.notNull(payload.getEventId(),"Id of event must not be null");
		return payload.getEventId();
	}
	
	public String getEventType(){
		Assert.notNull(payload.getEventType(),"EventType must not be null");
		return payload.getEventType().name();

	}
	


}
