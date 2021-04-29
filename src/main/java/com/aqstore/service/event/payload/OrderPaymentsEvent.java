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
public class OrderPaymentsEvent extends AbstractBaseEvent{

	
	private Long orderId;
	private String userId;
	private String refundedDescription;
	private Float orderPrice;
	
	
	
	@Override
	public String getPayloadId() {
		return orderId.toString();
	}

	
	
	
}
