package com.aqstore.service.event.payload.component;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventOrderItemDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8326323713625164045L;
	
	private Long itemId;
	private Integer quantity;
	private String name;
	private Float price;
	private Float cost;
	private Integer weight;
	private boolean confirmed;
	
}
