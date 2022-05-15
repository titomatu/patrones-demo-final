package edu.patrones.demo.helloworld;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello Wordl!!!!");
    }
}
