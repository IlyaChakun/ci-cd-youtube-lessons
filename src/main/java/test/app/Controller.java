package test.app;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class Controller {

    @GetMapping("/test-get")
    public String testGet() {
        return "Get works!";
    }

    @GetMapping("/test-load-cpu")
    public String loadCpu() {
        int numCore = 2;
        int numThreadsPerCore = 2;
        double load = 0.8;
        final long duration = 100000;
        for (int thread = 0; thread < numCore * numThreadsPerCore; thread++) {
            new BusyThread("Thread" + thread, load, duration).start();
        }

        return "done";
    }

    @PostMapping("/test-post")
    public String testPost(@RequestBody TestReq testReq) {
        System.out.println(testReq);
        return testReq.toString();
    }

}
