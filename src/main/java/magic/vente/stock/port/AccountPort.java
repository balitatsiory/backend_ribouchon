package magic.vente.stock.port;

import magic.vente.stock.domain.model.Account;

public interface AccountPort {
    boolean authenticateUser(Account account);
    void register(Account account);
}
