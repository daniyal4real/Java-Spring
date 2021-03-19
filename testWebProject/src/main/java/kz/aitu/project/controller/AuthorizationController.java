package kz.aitu.project.controller;


import kz.aitu.project.entity.Authorization;
import kz.aitu.project.service.AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody Authorization authorization){
        try {
            return ResponseEntity.ok(authorizationService.login(authorization));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/api/login/factory")
    public ResponseEntity<?> loginAdmin(@RequestBody Authorization authorization){
        try {
            return ResponseEntity.ok(authorizationService.loginFactory(authorization));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
