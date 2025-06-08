package magic.vente.stock.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import magic.vente.stock.domain.model.Item;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemRetrieveResponse {
    private long id;
    private String name;
    private String description;

    public static ItemRetrieveResponse of(Item item) {
        return ItemRetrieveResponse.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .build();
    }

    public  static List<ItemRetrieveResponse> of(List<Item> items) {
        return items.stream()
                .map(ItemRetrieveResponse::of)
                .toList();
    }
}
