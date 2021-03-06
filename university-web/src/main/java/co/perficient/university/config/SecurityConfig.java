package co.perficient.university.config;

import co.perficient.university.filter.CustomAuthenticationFilter;
import co.perficient.university.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Tell spring boot to look for the users
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

        //super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);

        http.authorizeRequests()
                .antMatchers("/api/login/**", "/api/users/token/refresh/**")
                .permitAll();

        http.authorizeRequests()
                .antMatchers(POST, "/api/users")
                .permitAll();

        /*http.authorizeRequests()
                .antMatchers(GET, "/api/**")
                .hasAnyAuthority("MANAGER", "VIEWER");*/

        http.authorizeRequests()
                .antMatchers(GET, "/api/**")
                .permitAll();

        http.authorizeRequests()
                .antMatchers(PUT, "/api/**")
                .hasAnyAuthority("MANAGER");

        http.authorizeRequests()
                .antMatchers(POST, "/api/**")
                .hasAnyAuthority("MANAGER");

        http.authorizeRequests()
                .antMatchers(DELETE, "/api/**")
                .hasAnyAuthority("MANAGER");

        //http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        //super.configure(http);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
