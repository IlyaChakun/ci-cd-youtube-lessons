package test.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class Controller {

    @GetMapping("/test-get")
    public ResponseEntity<String> testGet() {
        return ResponseEntity.ok("Get works!");
    }

    @PostMapping("/test-post")
    public ResponseEntity<String> testPost(@RequestBody TestReq testReq) {
        System.out.println(testReq);
        return ResponseEntity.ok(testReq.toString());
    }

}