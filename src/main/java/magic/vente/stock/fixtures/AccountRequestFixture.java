package magic.vente.stock.fixtures;

import magic.vente.stock.dto.request.AccountRequest;

public class AccountRequestFixture {
    public static final AccountRequest ACCOUNT_REQUEST;
    static {
        ACCOUNT_REQUEST = AccountRequest.builder()
                .username("client")
                .password("client")
                .build();
    }
}
