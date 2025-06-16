package magic.vente.stock.controller;

import lombok.RequiredArgsConstructor;
import magic.vente.stock.domain.service.AccountService;
import magic.vente.stock.dto.request.AccountRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AccountRequest accountRequest) {
        return accountService.login(accountRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AccountRequest accountRequest) {
        return accountService.register(accountRequest);
    }

}
