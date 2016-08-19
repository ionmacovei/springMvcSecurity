package net.codejava.spring.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource ds;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").access("hasRole('ROLE_ADMIN')").antMatchers("/admin/**")
				.access("hasRole('ROLE_ADMIN')").antMatchers("/dba/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')").and().formLogin();

	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		final String findUserQuery = "select username,password,enabled " + "from users " + "where username = ?";
		final String findRoles = "select username,authority " + "from role " + "where username = ?";

		auth.jdbcAuthentication().dataSource(ds).usersByUsernameQuery(findUserQuery)
				.authoritiesByUsernameQuery(findRoles);
	}
	//
	// @Override
	// public void configure(WebSecurity web) throws Exception {
	// web
	// .ignoring()
	// // Spring Security should completely ignore URLs starting with
	// /resources/
	// .antMatchers("/*.html");
	// }
}