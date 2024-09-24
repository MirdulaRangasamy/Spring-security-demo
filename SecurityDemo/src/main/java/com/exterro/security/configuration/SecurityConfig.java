package com.exterro.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf()
				.disable()
				.httpBasic()
				.and()
				.userDetailsService(userDetailsService)
				.authorizeHttpRequests(
						auth->auth
						.requestMatchers("/register", "/registerAdmin","/greet","/general").permitAll()
						.requestMatchers("/admin/*").hasAnyRole("ADMIN") 
						.anyRequest().authenticated())
				.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		UserDetails admin = User.withUsername("mirdu").password(encoder.encode("soorya")).roles("ADMIN").build();
//
//		return new InMemoryUserDetailsManager(admin);
//	}
	
// 	@Bean
// 	public WebSecurityCustomizer webSecurityCustomizer() {
// 		return (web) -> web.ignoring()
// 		// Spring Security should completely ignore URLs starting with /resources/
// 				.requestMatchers("/user/");
// 	}
	
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.httpBasic().and()
//				.csrf(csrf -> csrf.ignoringRequestMatchers("/home/**"))
//				.authorizeHttpRequests(auth -> auth
//						.requestMatchers("/home/**").permitAll()
//						.requestMatchers("/cars/**").hasAnyRole("USER","ADMIN")
//						.requestMatchers("/admin/**").hasAnyRole("ADMIN")
//						.anyRequest().authenticated())
//				.userDetailsService(jpaUserDetailsService)
//				.formLogin()
//				.and()
//				.build();
//	}
}
