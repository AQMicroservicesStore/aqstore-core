package com.aqstore.service.event.payload.component;

public enum CreateOrderSagaStep {

	STEP1_CREATE_ORDER,
	STEP2_CHECK_ITEMS,
	STEP3_CHECK_ADDRESS,
	STEP4_CONFIRM_PAYMENT,
	STEP5_ORDER_SHIPPED,
	STEP6_ORDER_DELIVERED
	;
	
}