package net.alkemi.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.annotation.JsonInclude;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select u.username, p.authority from authorities up inner join users u on u.username = up.username inner join authorities p on p.username = up.username where u.username = ?");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
				
				
				.antMatchers(HttpMethod.POST,"/api/**").permitAll()
				
				.antMatchers(HttpMethod.GET,"/api/users/**").permitAll()
				
				
				
				// Todas las demás URLs de la Aplicación requieren autenticación
				.anyRequest().authenticated()
				
				// El formulario de Login no requiere autenticacion
				.and().formLogin().permitAll();
	}
	

}