package com.paycore.CreditSystem.config;

import com.paycore.CreditSystem.security.JwtTokenFilterConfigurer;
import com.paycore.CreditSystem.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

// //--when need to login with user - password--

//        http.csrf().disable();
//
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.authorizeRequests()
//                .antMatchers("/users/signin").permitAll()
//                .antMatchers("/users/signup").permitAll()
//                // Disallow everything else..
//                .anyRequest().authenticated();
//
//        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
// -- --


//      -- when need to login without user - password--
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests().anyRequest().permitAll();

// -- --

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
