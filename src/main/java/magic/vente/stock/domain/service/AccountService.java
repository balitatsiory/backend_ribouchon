package magic.vente.stock.domain.service;

import lombok.RequiredArgsConstructor;
import magic.vente.stock.port.AccountPort;

@RequiredArgsConstructor
public class AccountService {
    private final AccountPort accountPort;

    public void createAccount(){

    }

    public void login(){

    }

    public void logout(){

    }

    public boolean validateToken(){
        return false;
    }

    public void refreshToken(){

    }

}
