package magic.vente.stock.port;

import magic.vente.stock.domain.model.Account;

import java.util.Optional;

public interface AccountPort {
    Optional<Account> retrieveAccount(String username);
    void register(Account account);
}
