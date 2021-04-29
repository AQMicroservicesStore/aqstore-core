package com.aqstore.service.event.payload;

import java.util.List;

import com.aqstore.service.event.payload.component.CreateOrderSagaStep;
import com.aqstore.service.event.payload.component.EventOrderItemDTO;
import com.aqstore.service.event.payload.component.EventUserAddressDTO;

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
public class OrderHistoryEvent extends AbstractBaseEvent{
	
	
	private Long orderId;
	private String status;
	private String idUser;
	private Long creationDate;
	private Long lastUpdate;
	private Float totalPrice;
	private Integer totalWeight;
	private String description;
	private EventUserAddressDTO userAddress;
	private List<EventOrderItemDTO> orderItems;	
	private Long eventStepId;
	private Long eventStepDate;
	@Builder.Default
	private CreateOrderSagaStep stepInfo=CreateOrderSagaStep.STEP1_CREATE_ORDER;
	
	@Override
	public String getPayloadId() {
		return getOrderId().toString();
	}



}
