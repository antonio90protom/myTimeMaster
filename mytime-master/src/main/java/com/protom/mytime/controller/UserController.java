package com.protom.mytime.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class UserController {
	
	@Autowired
	private TokenStore tokenStore;
	
	@GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Principal> get(final Principal principal) {
		return ResponseEntity.ok(principal);
    }
	
	@GetMapping("/check")
    @PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<String> check(@RequestHeader("Authorization") String token) {
		OAuth2AccessToken auth = tokenStore.readAccessToken(token.replace("Bearer ", ""));
		auth.getAdditionalInformation();
		return ResponseEntity.ok("ok");
	}

}
