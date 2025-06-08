package magic.vente.stock.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Item {
    private long id;
    private String name;
    private String description;
}
