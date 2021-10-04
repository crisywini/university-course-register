package co.perficient.university.filter;

import co.perficient.university.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/api/login")
                || request.getServletPath().equals("/api/user/token/refresh")) {
            filterChain.doFilter(request, response);
        } else {
            Util.processAuthorization(request, response, filterChain);
        }
    }
}
