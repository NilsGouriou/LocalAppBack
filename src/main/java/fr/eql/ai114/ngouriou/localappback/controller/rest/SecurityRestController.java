package fr.eql.ai114.ngouriou.localappback.controller.rest;

import fr.eql.ai114.ngouriou.localappback.entity.User;
import fr.eql.ai114.ngouriou.localappback.entity.dto.AuthRequest;
import fr.eql.ai114.ngouriou.localappback.entity.dto.AuthResponse;
import fr.eql.ai114.ngouriou.localappback.exception.AccountExistsException;
import fr.eql.ai114.ngouriou.localappback.exception.UnauthorizedException;
import fr.eql.ai114.ngouriou.localappback.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/security")
@CrossOrigin("${front.url}")
public class SecurityRestController {

    /** Injecté par le setter. */
	private SecurityService securityService;

	@PostMapping("/authorize")
	public ResponseEntity<AuthResponse> authorize(@RequestBody AuthRequest authRequest) throws UnauthorizedException {

        Authentication authentication;
        try {
            authentication = securityService.authenticate(authRequest.getUsername(), authRequest.getPassword());

            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user = (User) authentication.getPrincipal();
            String token = securityService.generateJsonWebTokenForUser(user);

            return ResponseEntity.ok(new AuthResponse(user, token));
        } catch(AuthenticationException e) {
            throw new UnauthorizedException();
        }
	}

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest requestDto) throws AccountExistsException {
        User user = securityService.save(requestDto.getUsername(), requestDto.getPassword());
        String token = securityService.generateJsonWebTokenForUser(user);
		return ResponseEntity.ok(new AuthResponse(user, token));
	}

    /// Setters ///
    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }
}
