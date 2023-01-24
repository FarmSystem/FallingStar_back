package login_test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecureConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure (HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/api/hello").permitAll()
                .antMatchers("/api/User").permitAll()
                .antMatchers("/api").permitAll()
                .antMatchers("/api/User/1").permitAll()
                .antMatchers("/api/User/2").permitAll()
                .antMatchers("/api/User/3").permitAll()
                .antMatchers("/api/User/4").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutUrl("/logout") //로그아웃 URL 매핑
                .logoutSuccessUrl("/home") //로그아웃시 redirect될 주소 매핑
                .invalidateHttpSession(true) //로그아웃시 세션 만료시키기 위한 옵션
                .and()
                .csrf().disable(); //POST 메소드를 자유롭게 쓰기 위한 옵션. 해당 구문이 없으면 POST 메소드로 호출시 403 Forbidden 출력

        return http.build();
    }
}

