package fr.eql.ai114.ngouriou.localappback.service;

//import fr.eql.akatz.cats.club.back.spring.exception.AccountExistsException;
import fr.eql.ai114.ngouriou.localappback.entity.User;
import fr.eql.ai114.ngouriou.localappback.exception.AccountExistsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface SecurityService extends UserDetailsService {

    Authentication authenticate(String username, String password) throws AuthenticationException;
    User save(String username, String password) throws AccountExistsException;
    String generateJsonWebTokenForOwner(User owner);
    User getOwnerFromJsonWebToken(String token);
}
