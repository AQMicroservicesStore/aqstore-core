package com.aqstore.service.event.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class OrderDeliveryEvent extends AbstractBaseEvent{

	
	private Long orderId;
	private String userId;
	private String fullAddress;
	
	@Override
	public String getPayloadId() {
		return orderId.toString();
	}
	
	
	

	
	
	
}
