package yg0r2.examples.behemoth.web.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class BehemothServiceWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

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
                .loginPage("http://localhost/auth/sign-in").permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
//                .antMatchers(HttpMethod.GET, "/sign-in").permitAll()
//                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                .anyRequest().authenticated();
    }

}
