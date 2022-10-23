package gym.gymServer.Security.Configuracion;

import gym.gymServer.Classes.UserLogin;
import gym.gymServer.Controller.UserLoginController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(UserLoginController userLoginController) {
        return args -> {
            userLoginController.registrarLogin(new UserLogin("admin", "admin", "Admin"));
        };
    }
}
