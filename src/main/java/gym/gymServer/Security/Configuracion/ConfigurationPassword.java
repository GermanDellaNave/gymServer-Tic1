package gym.gymServer.Security.Configuracion;

import gym.gymServer.Classes.UserLogin;
import gym.gymServer.Controller.UserLoginController;
import gym.gymServer.Repository.UserLoginRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ConfigurationPassword {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(UserLoginController userLoginController) {
        return args -> {
            userLoginController.registrarLogin(new UserLogin("admin", "admin", "Admin"));
        };
    }

    ;
}