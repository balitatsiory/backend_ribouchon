package magic.vente.stock.adapter;

import magic.vente.stock.adapter.data.CustomerData;
import magic.vente.stock.adapter.jpa.CustomerJpaRepository;
import magic.vente.stock.domain.model.Account;
import magic.vente.stock.domain.model.AccountType;
import magic.vente.stock.port.AccountPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AccountAdapter implements AccountPort {
    private final CustomerJpaRepository customerJpaRepository;

    public AccountAdapter(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public Optional<Account> retrieveAccount(String username) {
        Optional<CustomerData> customerData = customerJpaRepository.findByUsername(username);
        return customerData.map(c ->
                Account
                        .builder()
                        .username(c.getUsername())
                        .password(c.getPassword())
                        .accountType(AccountType.CUSTOMER)
                        .build()
        );
    }

    @Override
    public void register(Account account) {
        CustomerData customerData = CustomerData
                .builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .build();
        customerJpaRepository.save(customerData);
    }
}
