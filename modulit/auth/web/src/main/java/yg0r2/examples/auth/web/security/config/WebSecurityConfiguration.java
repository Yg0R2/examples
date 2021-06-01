package yg0r2.examples.auth.web.security.config;

import org.springframework.security.config.http.SessionCreationPolicy;
import yg0r2.examples.auth.service.UserServiceAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceAuthenticationProvider userServiceAuthenticationProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder
            .authenticationProvider(userServiceAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .cors()
                .and()
            .csrf()
                .disable() // https://github.com/spring-cloud/spring-cloud-netflix/issues/2754#issuecomment-372808529
            .httpBasic()
                .disable()
//                .and()
            .formLogin()
                .loginPage("http://auth-service.localhost/sign-in").permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
//            .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
//                .and()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/", "/static/**").permitAll()
                .antMatchers(HttpMethod.GET, "/sign-in").permitAll()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                .anyRequest().authenticated();
    }

}
