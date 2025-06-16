package magic.vente.stock.domain.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import magic.vente.stock.domain.model.Account;
import magic.vente.stock.domain.model.AccountType;
import magic.vente.stock.dto.request.AccountRequest;
import magic.vente.stock.port.AccountPort;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@Service
public class AccountService {
    private final AccountPort accountPort;
    private final TokenService tokenService;

    public ResponseEntity<String> login(@Valid AccountRequest accountRequest){
        Optional<Account> accountOptional = accountPort.retrieveAccount(
                accountRequest.getUsername()
        );

        if(accountOptional.isPresent()) {
            Account account = accountOptional.get();
            if(BCrypt.checkpw(accountRequest.getPassword(), account.getPassword())) {
                return ResponseEntity.ok(tokenService.generateToken(account));
            }
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(401)).build();
    }

    public ResponseEntity<?> register(@Valid AccountRequest accountRequest) {
        Account accountToCreate = Account
                .builder()
                .username(accountRequest.getUsername())
                .accountType(AccountType.CUSTOMER)
                .password(BCrypt.hashpw(accountRequest.getPassword(), BCrypt.gensalt()))
                .build();
        log.info("Account to create {}", accountToCreate.toString());
        accountPort.register(accountToCreate);
        return ResponseEntity.ok().build();
    }

}
