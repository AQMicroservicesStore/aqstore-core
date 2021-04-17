package com.aqstore.service.event;

public interface EventPayload<T> {

	public T getPayloadId();
	public EventType getEventType();

//	default String getIdentify() {
//		return identify().toString();
//	}


}
