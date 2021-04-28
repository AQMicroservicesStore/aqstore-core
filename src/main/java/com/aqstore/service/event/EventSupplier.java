package com.aqstore.service.event;

import org.springframework.cloud.stream.function.StreamBridge;

import com.aqstore.service.event.exception.EventExceptionType;
import com.aqstore.service.event.payload.EventPayload;
import com.aqstore.service.exception.AQStoreExceptionHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class EventSupplier {

		private final StreamBridge streamBridge;

		

		public <PAYLOAD extends EventPayload> void  delegateToSupplier(EventProducerWrapper<PAYLOAD> event) {	
			try {
				log.info("try to send message to TOPIC -> {} - ID_EVENT=[{}] - ID_PAYLOAD=[{}] ",event.getTopic(),event.getEventId(),event.getPayloadId());
				if(!streamBridge.send(event.getTopic(), event.getPayload())) {
					throw AQStoreExceptionHandler.handleException(EventExceptionType.EVENT_FAILED,event.getTopic(),event.getEventId(),event.getPayloadId());	
				}
				log.info("TOPIC -> {} - ID_EVENT=[{}] - ID_PAYLOAD=[{}]  - SENDED WITH SUCCESS",event.getTopic(),event.getEventId(),event.getPayloadId());
			}catch (Exception e) {
				log.info("failed to send event TOPIC -> {} - ID_EVENT=[{}] - ID_PAYLOAD=[{}]",event.getTopic(),event.getEventId(),event.getPayloadId());
				throw AQStoreExceptionHandler.handleException(e);
			}

		}


		
		
}
