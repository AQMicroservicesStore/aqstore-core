package com.aqstore.service.security;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class KeycloakRealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>>{

	@Override
	@SuppressWarnings("unchecked")
	public Collection<GrantedAuthority> convert(final Jwt jwt) {
		final Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");
		List<GrantedAuthority> roles =  ((List<String>) realmAccess.get("roles")).stream()
				.map(roleName -> "ROLE_" + roleName.toUpperCase())
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		return roles;
	}
	
	
}
