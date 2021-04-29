package com.aqstore.service.event.payload;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class OrderCheckAddressEvent extends AbstractBaseEvent{

	
	private Long orderId;
	private String userId;
	
	
	@Builder.Default
	private String eventId = UUID.randomUUID().toString();


	@Override
	public String getPayloadId() {
		return orderId.toString();
	}
	

	
	
	
}
