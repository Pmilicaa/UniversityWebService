
package com.uni.UniversityWebService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.uni.UniversityWebService.security.AuthenticationTokenFilter;
import com.uni.UniversityWebService.services.UserDetailsServiceImpl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {



    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configureAuthentication(
            AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {

        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService).passwordEncoder(
                passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationTokenFilter authenticationTokenFilterBean()
            throws Exception {
        AuthenticationTokenFilter authenticationTokenFilter = new AuthenticationTokenFilter();
        authenticationTokenFilter
                .setAuthenticationManager(authenticationManagerBean());
        return authenticationTokenFilter;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedOriginPatterns("*").allowedHeaders("*").allowedMethods("GET" , "POST" , "PUT" , "DELETE" , "OPTIONS" , "HEAD");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/", "/api/login", "/styles.css", "/profile", "/examParts/paged",
                        "/runtime.js", "/polyfills.js", "/vendor.js", "/main.js", "/images/**", "/js/**",
                        "/runtime-es2015.js", "/polyfills-es2015.js", "/vendor-es2015.js", "/main-es2015.js").permitAll()
                .antMatchers(HttpMethod.POST,"/users","/teachers").permitAll()
                .antMatchers(HttpMethod.GET,"/teachers").permitAll()
                .antMatchers("/students/me", "/documents/me", "/enrollments/me", "/examParts/register/*", "/examParts/cancel/*").hasRole("STUDENT")
                .antMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/teaching/**").permitAll()
                .antMatchers(HttpMethod.GET, "/students/**", "/teaching/**", "/teachers/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/students/**").permitAll()
                .antMatchers(HttpMethod.POST, "/teaching/teacher/{id}").permitAll()
                .anyRequest().authenticated();
        httpSecurity.cors();

        // Custom JWT based authentication
        httpSecurity.addFilterBefore(authenticationTokenFilterBean(),
                UsernamePasswordAuthenticationFilter.class);
    }

}
