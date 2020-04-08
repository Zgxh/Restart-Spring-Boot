package com.zgxh.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Yu Yang
 * @create 2020-04-08 16:04
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter { // 2. 通过配置类的方式配置spring security的登录账户,配置在内存中

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // spring security提供的密码编码工具，实现密码的加密加盐，相同明文加密出来的结果总是不同
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // 在内存中配置了两个用户登录信息
        auth.inMemoryAuthentication()
                .withUser("zgxh")
                .roles("admin")
                .password(passwordEncoder().encode("12345678"))
                .and() // 通过and()连接不同的用户
                .withUser("renyan")
                .roles("user")
                .password(passwordEncoder().encode("123"));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/nosecurity"); // 忽略拦截，spring security 过滤某个 url
    }


}
