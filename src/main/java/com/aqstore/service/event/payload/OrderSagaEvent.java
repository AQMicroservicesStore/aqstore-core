package com.aqstore.service.event.payload;

import java.util.List;

import com.aqstore.service.event.payload.component.CreateOrderSagaStep;
import com.aqstore.service.event.payload.component.EventOrderItemDTO;
import com.aqstore.service.event.payload.component.EventUserAddressDTO;

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
public class OrderSagaEvent extends AbstractBaseEvent{

	private Long orderId;
	private String errorMessages;
	private EventUserAddressDTO userAddress;
	private List<EventOrderItemDTO> orderItems;
	private Long eventStepId;
	private Long eventStepDate;
	private CreateOrderSagaStep stepInfo;
	

	@Override
	public String getPayloadId() {
		return orderId.toString();
	}
	
}
