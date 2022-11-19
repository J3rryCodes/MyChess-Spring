package online.ij3rry.my_chess.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity getHealthStatus(){
        return new ResponseEntity<String>("Health is good",HttpStatus.OK);
    }
}
