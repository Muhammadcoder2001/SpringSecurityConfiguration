package com.Muhammadcoder.SpringSecurity_for_github.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
             .csrf(customizer-> customizer.disable())
                     .authorizeRequests(request-> request
                             .anyRequest().authenticated())
                     .httpBasic(Customizer.withDefaults())
               .sessionManagement(session->
                       session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .build();

        //http.formLogin(Customizer.withDefaults());

//                CSRF disable qilishning Eng tag qismidagi jarayoni
//        Customizer<CsrfConfigurer<HttpSecurity>> Csrf = new Customizer<CsrfConfigurer<HttpSecurity>>(){
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//                customizer.disable();
//            }
//        };
//                 return http.build();

    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    //Default holatda foydalinib ko'rib tushunib olish uchun foydalanildi

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("coder")
//                .password("c@123")
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("mirabbos")
//                .password("m@123")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

}
