package com.laziobird.security;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author 蒋志伟
 * @version 创建时间：2018年11月9日 下午2:38:11
 */
@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// 设置 HTTP 验证规则
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 关闭csrf验证
		http.csrf().disable()
				// 对请求进行认证
				.authorizeRequests()
				// 所有/的所有请求 都放行
				.antMatchers("/").permitAll().antMatchers("/permission/**").permitAll().antMatchers("/role/**").permitAll().antMatchers("/user/**")
				.permitAll().antMatchers("/swagger-ui**").permitAll().antMatchers("/back/**").permitAll()
				.antMatchers("/front/**").permitAll().antMatchers("/js/**").permitAll().antMatchers("/css/**")
				//兼容swagger
				.permitAll().antMatchers("/webjars/**").permitAll().antMatchers("/swagger-resources").permitAll().antMatchers("/images/**").permitAll()
				.antMatchers("/v2/api-docs").permitAll()
				// 所有 /api/v1/login 的POST请求 都放行
				.antMatchers(HttpMethod.POST, "/api/v1/login").permitAll()
				// 权限检查
				.antMatchers("/hello").hasAuthority("AUTH_WRITE")
				// 角色检查
				.antMatchers("/admin/**").hasRole("ADMIN")
				// 所有请求需要身份认证
				.anyRequest().authenticated().and()
				// 添加一个过滤器 所有访问 /login 的请求交给 JWTLoginFilter 来处理 这个类处理所有的JWT相关内容
				.addFilterBefore(new JWTLoginFilter("/api/v1/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				// 添加一个过滤器验证其他请求的Token是否合法
				.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 使用自定义身份验证组件
		auth.authenticationProvider(new CustomAuthenticationProvider());

	}
}