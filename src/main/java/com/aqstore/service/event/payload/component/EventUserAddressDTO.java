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
public class EventUserAddressDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4193434995381034842L;
	private String fullName;
	private String country;
	private String cap;
	private String city;
	private String street;
	
	
	public String getFullAddress() {
		StringBuilder sb = new StringBuilder();
		sb.append(fullName)
		.append(", ")
		.append(street)
		.append(", ")
		.append(cap)
		.append(" ")
		.append(city)
		.append(", ")
		.append(country);
		return sb.toString();
	}
	
	
}
