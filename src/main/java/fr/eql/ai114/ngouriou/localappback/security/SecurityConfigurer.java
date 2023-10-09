package fr.eql.ai114.ngouriou.localappback.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {


    @Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and();

        // Set unauthorized requests exception handler
        http = http
            .exceptionHandling()
            .authenticationEntryPoint(new SecurityEntryPoint())
            .and();

        // Set permissions on endpoints
        http
            .authorizeRequests()
            // Our public endpoints
            .antMatchers("/font-awesome-4.7.0/**/**").permitAll()
            .antMatchers("/").permitAll()
            .antMatchers("/**/*.html").permitAll()
            .antMatchers("/**/*.css").permitAll()
            .antMatchers("/**/*.js").permitAll()
            .antMatchers("/**/*.jpg").permitAll()
            .antMatchers("/api/security/**").permitAll()
            .antMatchers("/api/glossary/**").permitAll();

            // Our private endpoints
            //.anyRequest().authenticated();

        http
            .addFilterBefore(securityFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public SecurityFilter securityFilter() {
        return new SecurityFilter();
    }


}