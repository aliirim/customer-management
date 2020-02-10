package com.techpeak.customermanagement.config;

import java.util.Arrays;

import com.techpeak.customermanagement.security.AuthorizationFilter;
import com.techpeak.customermanagement.security.JwtAuthenticationEntryPoint;
import com.techpeak.customermanagement.security.SecurityConstants;
import com.techpeak.customermanagement.service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    private final UserDetailsServiceImpl userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, JwtAuthenticationEntryPoint unauthorizedHandler) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.unauthorizedHandler = unauthorizedHandler;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors().and()
        .csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
        .permitAll()
        .antMatchers(HttpMethod.GET, SecurityConstants.VERIFICATION_EMAIL_URL)
        .permitAll()
        .antMatchers(HttpMethod.POST, SecurityConstants.PASSWORD_RESET_REQUEST_URL)
        .permitAll()
        .antMatchers(HttpMethod.POST, SecurityConstants.PASSWORD_RESET_URL)
        .permitAll()
        .antMatchers(SecurityConstants.H2_CONSOLE)
        .permitAll()
        .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**","/api/token/register", "/api/token")
        .permitAll()
        .anyRequest().authenticated().and()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .addFilter(new AuthorizationFilter(authenticationManager()))
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource()
    {
    	final CorsConfiguration configuration = new CorsConfiguration();
    	   
    	configuration.setAllowedOrigins(Arrays.asList("*"));
    	configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE","OPTIONS"));
    	configuration.setAllowCredentials(true);
    	configuration.setAllowedHeaders(Arrays.asList("*"));
    	
    	final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	source.registerCorsConfiguration("/**", configuration);
    	
    	return source;
    }
}
