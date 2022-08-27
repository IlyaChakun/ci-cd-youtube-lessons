package test.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerV3 {

    @GetMapping("/service/test-service/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Healthy");
    }

}
