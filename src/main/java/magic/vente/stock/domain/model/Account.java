package magic.vente.stock.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Account {
    private long id;
    private String username;
    private String password;
    private AccountType accountType;
}
