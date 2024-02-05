package io.demo.product.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class MainSecurityConfig {

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        NullRequestCache requestCache = new NullRequestCache();
        http
        .authorizeHttpRequests((requests) -> requests
            .requestMatchers(
                "/img/**",
                "/js/**",
                "/css/**",  
                "/error",
                "/vue/login/**",
                "/favicon.ico",
                "/manifest.json",
                "/index.html").permitAll()
            .anyRequest()
            .authenticated())
        .csrf(csrf -> csrf.disable())
        .formLogin((form) -> form
            .loginProcessingUrl("/vue/login")
            .loginPage("/vue/login")
            .defaultSuccessUrl("/vue/dashboard")
        )
        .requestCache(cache -> cache.requestCache(requestCache))
        .logout((logout) -> logout.permitAll());
        return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
