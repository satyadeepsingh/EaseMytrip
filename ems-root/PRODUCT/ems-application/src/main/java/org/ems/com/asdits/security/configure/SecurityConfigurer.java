package org.ems.com.asdits.security.configure;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfigurer.class);

	@Autowired(required = true)
	private BCryptPasswordEncoder encoder;

	@Autowired
	private DataSource dataSource;

	@Value("${login.username.query}")
	private String usernameQuery;

	 @Value("${login.roles.query}")
	 private String rolesQuery;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("checking the securty context:{}", http.securityContext().toString() );

		http.csrf().disable().authorizeRequests().antMatchers("/","/h2-console","/login").permitAll()
				.antMatchers(HttpMethod.POST, "/emt/createuser").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.failureUrl("/login?error=true").defaultSuccessUrl("/welcome",true).usernameParameter("username")
				.passwordParameter("password").and().logout().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
		
		authBuilder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder)
				.usersByUsernameQuery(usernameQuery).authoritiesByUsernameQuery(rolesQuery);
		logger.info("checking auth : {}", authBuilder.jdbcAuthentication().toString());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}