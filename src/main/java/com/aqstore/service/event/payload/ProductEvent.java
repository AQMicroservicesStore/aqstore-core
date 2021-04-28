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
public class ProductEvent extends AbstractBaseEvent{

	
	private Long id;
	private Long createdDate;
	private int version;
	private String name;
	private String type;
	private String brand;
	private Integer weight;
	private String description;
	private Integer quantity;
	private Float priceToSell;
	private Float purchaseCost;
	private Long lastProductModifiedDate;	
	private Long lastStockModifiedDate;	
	
	
	@Override
	public String getPayloadId() {
		return id.toString();
	}

	
	
	
}
