package software.onepiece.javarcade.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@Import(WebSocketConfig.class)
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("Main - Module: " + Application.class.getModule());
        SpringApplication.run(Application.class, args);
    }

    // Component scanning does not work after 'jpackage' (why?)
    // public static class Config {
    //     @Bean
    //     public AppServlet appServlet(){
    //         return new AppServlet();
    //     }
    // }
}