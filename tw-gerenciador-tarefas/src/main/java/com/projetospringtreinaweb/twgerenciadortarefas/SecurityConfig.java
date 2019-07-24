package com.projetospringtreinaweb.twgerenciadortarefas;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author WellintonCamboim-14-07-2019-Aula03-TreinoWeb
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;		
	
	//Para consultar na tabela de Usuario-Conexao
//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private DataSource dataSource;
	

	//Usuario
	@Value("${spring.queries.users-query}")
	private String userQuery;
	
	//Perfil
	@Value("${spring.queries.roles-query}")
	private String roleQuery;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.jdbcAuthentication()
			.usersByUsernameQuery(userQuery)
			.authoritiesByUsernameQuery(roleQuery)
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/registration").permitAll()
			.anyRequest()
				.authenticated()
					.and().csrf().disable()
				.formLogin()
					.loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/")
					.usernameParameter("email").passwordParameter("senha")
				.and().logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
					
	}
	
	//Para ignorar o Bootstrap, ou seja, para liberar o uso de qualquer urls que comece com webjars
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/webjars/**");
	}
}
