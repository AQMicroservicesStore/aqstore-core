package com.aqstore.service.event;

public enum EventType {

	CQRS_CREATED,
	CQRS_UPDATED,
	CQRS_DELETED,
	SAGA_ROLLBACK,
	SAGA_ERROR_ROLLBACK,
	SAGA_CONTINUE,
	IGNORE
}
