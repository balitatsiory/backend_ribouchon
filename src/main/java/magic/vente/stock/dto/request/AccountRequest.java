package magic.vente.stock.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
@Builder
public class AccountRequest {
    @NotNull
    private final String username;
    @NotNull
    private final String password;
}
