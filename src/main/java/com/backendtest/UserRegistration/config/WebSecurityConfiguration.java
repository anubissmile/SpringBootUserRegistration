package com.backendtest.UserRegistration.config;

import com.backendtest.UserRegistration.User.service.MyUserDetailService;
import com.backendtest.UserRegistration.filter.JWTRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import javax.servlet.Filter;
import java.util.Arrays;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private JWTRequestFilter jwtRequestFilter;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(myUserDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("configure");
        http.cors().and().csrf().disable();
        http.cors().configurationSource(request -> new CorsConfiguration(corsConfiguration()));

        try {
//            http.antMatcher("/**")
//                    .authorizeRequests()
//                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                    .antMatchers("/authenticate").permitAll()
//                    .anyRequest().authenticated()
//                    .and().sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.authorizeRequests().antMatchers("/authenticate").permitAll()
                    .anyRequest().authenticated()
                    .and().sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() { return NoOpPasswordEncoder.getInstance(); }

    CorsConfiguration corsConfiguration() {
        CorsConfiguration corsConfiguration  = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:2534"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control, Allow-Origin", "Content-Type", "Accept", "Authorization", "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Header" ));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization", "Access-Control-Request-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        return corsConfiguration ;
    }
}
