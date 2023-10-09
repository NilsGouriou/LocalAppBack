package fr.eql.ai114.ngouriou.localappback.entity.dto;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthResponse {

	private UserDetails user;
	private String token;

    public AuthResponse(UserDetails user, String token) {
        this.user = user;
        this.token = token;
    }

	public UserDetails getUser() {
		return user;
	}
	public String getToken() {
		return token;
	}
}
