package marsa.maroc.GestionNavires.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder=passwordEncoder();
		auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("1234")).roles("USER");
		auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("abcd")).roles("USER");
		auth.inMemoryAuthentication().withUser("admin1").password(passwordEncoder.encode("4321")).roles("USER","ADMIN");
		auth.inMemoryAuthentication().withUser("admin2").password(passwordEncoder.encode("abcd")).roles("USER","ADMIN");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/add**/**","/delete**/**").hasRole("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		http.csrf().disable();
		http.exceptionHandling().accessDeniedPage("/notAuthorized");
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
}
