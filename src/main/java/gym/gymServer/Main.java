package gym.gymServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Main {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {

        Main.context = SpringApplication.run(Main.class);
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }

}
