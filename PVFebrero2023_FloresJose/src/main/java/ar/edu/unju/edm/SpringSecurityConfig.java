package ar.edu.unju.edm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	//rutas url
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/listar", "/images/**").permitAll()
		.antMatchers("/eliminar/**").hasAnyRole("USER")//por cada pagina q le quieras poner url hay q poner esto
		.antMatchers("/form/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login")
		.permitAll()
		.and()
		.logout().permitAll()
		;
	}
	
	//creacion de usuario y encriptamiento de password

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();//esta funcion encripta las password
	}
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);//para encriptar las password
		
		builder.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))//una vez que pasan x password sin teenr q llamar al
		//metodo se encodan y se registtra el usuario con esa password, es como una forma licita para registrar los usuarios
		.withUser(users.username("maxi").password("12345").roles("USER"));
		
	}
		
}
