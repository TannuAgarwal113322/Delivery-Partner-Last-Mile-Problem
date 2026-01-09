package com.example.getcash.GetCashApi.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.getcash.GetCashApi.UtilityHelper.JwtHelper;
import com.example.getcash.GetCashApi.service.CostumeUserDetailsService;
@Service
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	private CostumeUserDetailsService customUserDetailsService;
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
	    String path = request.getServletPath();
	    return path.equals("/user/login")
	        || path.equals("/user/registerUser")  || path.equals("/user/loginOtp");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer "))
			jwtToken = requestTokenHeader.substring(7);
		try {
			username = this.jwtHelper.extractUsername(jwtToken);

		} catch (Exception e) {

			e.printStackTrace();
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
					userDetails, null, userDetails.getAuthorities());

			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

		} else {
			System.out.println("Token is not valid or already authenticated");
		}

		filterChain.doFilter(request, response);
	}

}
