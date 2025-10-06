package com.finance.financialaccount.controller;

import com.finance.financialaccount.dto.CredenciaisDTO;
import com.finance.financialaccount.dto.TokenDTO;
import com.finance.financialaccount.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager authManager, TokenService tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody CredenciaisDTO cred) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(cred.email(), cred.password())
        );
        String jwt = tokenService.gerarToken(authentication);
        return ResponseEntity.ok(new TokenDTO(jwt));
    }
}
