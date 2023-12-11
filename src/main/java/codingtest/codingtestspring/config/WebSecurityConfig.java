package codingtest.codingtestspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Bean
    public SecurityFilterChain configureHttpSecurity(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .defaultSuccessUrl("/login")
                        .permitAll()
                )
                .logout(withDefaults());
        return http.build();
    }

    @Bean
    @Primary
    protected AuthenticationManagerBuilder configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER");
        return auth;
    }
}
