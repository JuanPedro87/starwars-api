package com.example.start.wars.config;

import com.example.start.wars.auth.FakeAuthProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jpcs1 on 14/07/17.
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SegurityConfigurator extends WebSecurityConfigurerAdapter {

    private FakeAuthProvider fakeAuthProvider;

    public SegurityConfigurator(FakeAuthProvider fakeAuthProvider) {
        this.fakeAuthProvider=fakeAuthProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception {
        //por defecto
        //auth.authenticationProvider(fakeAuthProvider);
        // usuarios concretos
         auth.inMemoryAuthentication().withUser("user").password("password").roles("ADMIN")
                .and().withUser("lele").password("ggg").roles();

    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws  Exception{
        // con form login
        //httpSecurity.formLogin().and()
        // .authorizeRequests()
        //        .antMatchers("/planets**").permitAll()
        //        .antMatchers("/films**").hasRole("ADMIN")
        //        .antMatchers("/peoples**").authenticated();

        // sin formulario login
        httpSecurity.httpBasic().and()
                .authorizeRequests()
                .antMatchers("/films**").permitAll()
                .antMatchers("/planets**").hasRole("ADMIN")
                .antMatchers("/peoples**").authenticated();
    }

}
