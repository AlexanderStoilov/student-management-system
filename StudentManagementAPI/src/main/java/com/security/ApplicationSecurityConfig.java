package com.security;

import com.auth.user.ApplicationUserService;
import com.jwt.JwtTokenVerifier;
import com.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.security.user.ApplicationUserRole.STUDENT;
import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@SuppressWarnings(value = "unused")
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }

    void configureHttp(HttpSecurity http) throws Exception {
        // TODO check PreAuthorize in controllers - they lead to problems sometimes
        http.authorizeRequests().antMatchers(POST, "/api/v1/courses/{courseId}/add_teacher/{teacherId}").hasAuthority("course:add_teacher");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        configureHttp(http);
        //        http
        //                .cors()
        //                .and()
        //                .csrf().disable()
        //                .sessionManagement()
        //                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        //                .and()
        //
        ////                .formLogin()
        ////                .defaultSuccessUrl("/index", true)
        ////                .failureUrl("/login.html?error=true")
        ////                .and()
        //
        //                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
        //                .addFilterAfter(new JwtTokenVerifier(), JwtUsernameAndPasswordAuthenticationFilter.class)
        //                .authorizeRequests()
        //                .antMatchers("/registration", "/login", "/css/*", "/js/*", "/api/users/**").permitAll()
        //                .antMatchers("/users/**").permitAll() // TODO - for Angular setup
        //                .anyRequest()
        //                .authenticated()
        //                .and()
        //                .httpBasic()
        //
        //                .and()
        //                .logout()
        //                .logoutUrl("/logout")
        //                .logoutSuccessUrl("/login")
        //                .invalidateHttpSession(true)
        //                .deleteCookies("JSESSIONID")

        //  2
        //        http
        //                .cors()
        //                .and()
        //                .csrf().disable()
        //                .authorizeRequests()
        //                .antMatchers("/login", "/index", "/css/*", "/js/*", "/register", "/users/**")
        //                .permitAll()
        //                .anyRequest()
        //                .authenticated()
        //                .and()
        //                .formLogin()
        //                .and()
        //                .logout()
        //                .logoutUrl("/logout")
        //                .logoutSuccessUrl("/")
        //                .invalidateHttpSession(true)
        //                .deleteCookies("JSESSIONID")
        ;

        // 3
        //        http
        //                .cors()
        //                .and()
        //                .csrf().disable()
        //                .authorizeRequests()
        //                .antMatchers("/**").fullyAuthenticated()
        ////                .antMatchers("/login", "/index", "/css/*", "/js/*", "/register", "/users/**").permitAll()
        //                .and()
        //                .httpBasic();

        //                .httpBasic();
        //                .and()
        //                .logout()
        //                .logoutUrl("logout")
        //                        .logoutSuccessUrl("/")
        //                .invalidateHttpSession(true)
        //                .deleteCookies("JSESSIONID");
        ;

        // working -> login, not working -> other reqs
        //        http
        //                .csrf().disable()
        //                .sessionManagement()
        //                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        //                .and()
        //                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
        //                .addFilterAfter(new JwtTokenVerifier(),JwtUsernameAndPasswordAuthenticationFilter.class)
        //                .authorizeRequests()
        //                .antMatchers("/login/**", "/index", "/register/**", "/js/*").permitAll()
        //                .antMatchers("/api/**").hasRole(STUDENT.name())
        //                .anyRequest()
        //                .authenticated()
        //                .and()
        //                .httpBasic()
        //        ;

        http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifier(), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/registration", "/login", "/css/*", "/js/*", "/api/users/**").permitAll()
                .antMatchers("/users/**").permitAll() // TODO - for Angular setup
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }
}
