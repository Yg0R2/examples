package yg0r2.examples.auth.web.security.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
//@ConditionalOnProperty(name = "examples.behemoth", havingValue = "false", matchIfMissing = true)
public class AuthServiceWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

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
                .disable()
            .httpBasic()
                .disable()
//                .and()
            .formLogin()
                .loginPage("https://localhost/auth/sign-in").permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET, "/sign-in").permitAll()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                .anyRequest().authenticated();
    }

}
