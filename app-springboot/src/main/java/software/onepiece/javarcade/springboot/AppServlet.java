package software.onepiece.javarcade.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.onepiece.javarcade.model.Level;

import java.io.IOException;

@RestController
public class AppServlet {

    @GetMapping("/")
    public String index() throws IOException {
        Level level = null;

        return "<html><body>" +
                "App is running... !!!!" +
                "<br/>Level " + level +
                "</body></html>";
    }
}