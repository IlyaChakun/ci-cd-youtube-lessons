package test.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerV3 {

    @GetMapping("/service/test-service/health")
    public String health() {
        return "good";
    }

}
