package magic.vente.stock.adapter;

import magic.vente.stock.domain.model.Account;
import magic.vente.stock.domain.model.AccountType;
import magic.vente.stock.port.AccountPort;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AccountAdapterInMemory implements AccountPort {
    private final List<Account>  accounts ;

    public AccountAdapterInMemory(){
        accounts = new ArrayList<>();
        accounts.add(
                Account.builder()
                        .username("client")
                        .password(BCrypt.hashpw("client", BCrypt.gensalt()))
                        .accountType(AccountType.CUSTOMER)
                        .build())
        ;
    }

    @Override
    public Optional<Account> retrieveAccount(String username) {
        return accounts.stream().filter(a -> a.getUsername().equals(username)).findFirst();
    }

    @Override
    public void register(Account account) {
        accounts.add(account);
    }
}
