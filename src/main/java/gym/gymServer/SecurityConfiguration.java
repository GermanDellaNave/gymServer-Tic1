package gym.gymServer;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;


public class SecurityConfiguration extends WebSecurityConfiguration {

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("")
    }*/
}
