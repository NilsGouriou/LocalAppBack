package fr.eql.ai114.ngouriou.localappback.service.impl;

import fr.eql.ai114.ngouriou.localappback.exception.AccountExistsException;
import fr.eql.ai114.ngouriou.localappback.repository.UserDao;
import fr.eql.ai114.ngouriou.localappback.service.SecurityService;
import fr.eql.ai114.ngouriou.localappback.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Configuration
public class SecurityServiceImpl implements SecurityService {

    private UserDao userDao;
	private AuthenticationManager authenticationManager;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final String signingKey;

    public SecurityServiceImpl(@Value("${jwt.signing.key}") String signingKey) {
        this.signingKey = signingKey;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("The user could not be found");
        }
        return user;
    }

    // Used for registration
    public User save(String username, String password) throws AccountExistsException {
        if (userDao.findByLogin(username) != null) {
            throw new AccountExistsException();
        }
        User user = new User();
        user.setLogin(username);
        user.setPassword(passwordEncoder().encode(password));
		userDao.save(user);
        return user;
    }

    // Used for authentication
    public User getUserFromJsonWebToken(String token) {
        String username = getUsernameFromToken(token);
        return (User) loadUserByUsername(username);
    }

    private String getUsernameFromToken(String token) {
        System.out.println(signingKey);
        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public String generateJsonWebTokenForUser(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600 * 1000);
        return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(now).setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, signingKey)
            .compact(); 
    }

    public Authentication authenticate(String username, String password) throws AuthenticationException {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authentication);
    }

    /// Setters ///
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}
