package com.springsecuritydemo.springsecurityapp.webconfig;

import ch.qos.logback.core.joran.action.NOPAction;
import ch.qos.logback.core.testUtil.NPEAppender;
import com.springsecuritydemo.springsecurityapp.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/","/create","/home","/register","/manage/app-sec/getUsers")
                        .permitAll()
   //                     .requestMatchers("/examResults").hasRole("ROLE_USER")
                        .requestMatchers("/students").hasRole("USER")
                        .requestMatchers("/subjects").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .formLogin((form)->form.loginPage("/login").permitAll())
                .logout((logout)->logout.permitAll());

        return http.build();
    }


/*    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

*/
    @Bean
    public UserDetailsService users(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public static PasswordEncoder getPasswordEncoder(){
        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }


/*    @Bean
    public static StudentService getStudentService(){
        return new StudentService();
    }*/
}
