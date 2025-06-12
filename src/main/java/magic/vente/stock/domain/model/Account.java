package magic.vente.stock.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Account {
    private long id;
    private String username;
    private String password;
    private AccountType accountType;
}
