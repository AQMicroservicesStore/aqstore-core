package com.aqstore.service.event.payload;

import java.util.ArrayList;
import java.util.List;

import com.aqstore.service.event.payload.component.EventOrderItemDTO;

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
public class OrderCheckItemEvent extends AbstractBaseEvent{

	
	private Long orderId;
	@Builder.Default
	private List<EventOrderItemDTO> items=new ArrayList<>();
	
	@Override
	public String getPayloadId() {
		return orderId.toString();
	}
	
	
	
	
	
	
}
