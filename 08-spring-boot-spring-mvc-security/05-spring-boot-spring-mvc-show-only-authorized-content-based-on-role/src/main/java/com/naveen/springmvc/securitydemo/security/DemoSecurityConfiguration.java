package com.naveen.springmvc.securitydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfiguration {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        // Storing the username, password and roles in the application
////
////        UserDetails john = User.builder()
////                .username("john")
////                .password("{noop}test123")
////                .roles("EMPLOYEE")
////                .build();
////
////        UserDetails mary = User.builder()
////                .username("mary")
////                .password("{noop}test123")
////                .roles("EMPLOYEE", "MANAGER")
////                .build();
////
////        UserDetails susan = User.builder()
////                .username("susan")
////                .password("{noop}test123")
////                .roles("EMPLOYEE", "MANAGER", "ADMIN")
////                .build();
////
////        return new InMemoryUserDetailsManager(john, mary, susan);
////    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // All requests coming should go though login form
        // NO user can access without the authentication
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasAnyRole("MANAGER","ADMIN")
                                .requestMatchers("/systems/**").hasRole("ADMIN")
                                .anyRequest().authenticated()


                )
                .formLogin(form ->
                        form        // this is the login request mapping to the controller
                                    // which redirects to the login page
                                .loginPage("/showMyLoginPage")

                                //This is taken care of Spring Boot
                                // make sure to use form name correctly as name and password
                                .loginProcessingUrl("/authenticateTheUser")
                                // Allow everyone to see Login page
                                .permitAll()
                )
                .logout(logout-> logout.permitAll()
                ).exceptionHandling(configurer->
                        configurer.accessDeniedPage("/access-denied"));
        return http.build();

    }


        // Add jdbc authenticaiton , no hard code!!!
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        return new JdbcUserDetailsManager(dataSource);
        // No code needed, authentication will be take care of Springboot
        // using the default table and column names
    }
}