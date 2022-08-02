//package com.cirbal.portfel.config;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.cirbal.portfel.services.JwtUserDetailsService;
//
//import io.jsonwebtoken.ExpiredJwtException;
//
//@Component
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//	@Autowired
//	private JwtUserDetailsService jwtUserDetailsService;
//
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws ServletException, IOException {
//
//		final String requestTokenHeader = request.getHeader("Authorization");
//
//		String username = null;
//		String jwtToken = null;
//		// El token JWT tiene la forma de "token de portador". Eliminar la palabra portadora y obtener
//		// solo el token                                   startsWith("portador ")) {
//		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//			jwtToken = requestTokenHeader.substring(7);
//			try {
//				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//			} catch (IllegalArgumentException e) {
//				System.out.println("Unable to get JWT Token");
//			} catch (ExpiredJwtException e) {
//				System.out.println("JWT Token has expired");
//			}
//		} else {
//			logger.warn("El token JWT no comienza con portador");
//		}
//
//		// Una vez que obtengamos el token, validamos.
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
//
//			// si el token es válido, configure Spring Security para configurarlo manualmente
//			// autenticación
//			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());
//				usernamePasswordAuthenticationToken
//						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				// Después de configurar la Autenticación en el contexto, especificamos
//				// que el usuario actual está autenticado. Así pasa el
//				// Configuraciones de Spring Security con éxito.
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//			}
//		}
//		chain.doFilter(request, response);
//	}
//
//}