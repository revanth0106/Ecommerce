package com.ecommerce.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {
		//get the token from Header
		String token=getToken(request);
		//Check the token either vaild or invaild
		//load the user and set autentication
		
	}

	private String getToken(HttpServletRequest request) {
		String token=request.getHeader("authenticate");
		if(StringUtils.hasText(token)&& token.startsWith("Bearer")) {
			return token.substring(7, token.length());
		};
		return null;
		
	}
}
