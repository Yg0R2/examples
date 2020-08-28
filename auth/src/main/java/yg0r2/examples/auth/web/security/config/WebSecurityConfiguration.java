package yg0r2.examples.auth.web.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .cors()
                .and()
            .csrf()
                .disable()
            .httpBasic()
                .and()
            .formLogin()
                .and()
            .authorizeRequests()
                .anyRequest().authenticated();
    }

}
