package magic.vente.stock.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Customer {
    private long id;
    private Account account;
}
