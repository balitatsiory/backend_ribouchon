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
    private String label;
    private String reference;
    private boolean isTrendToday;
    private double price;
    private int quantityInStock;


    public static ItemRetrieveResponse of(Item item) {
        return ItemRetrieveResponse.builder()
                .id(item.getId())
                .label(item.getLabel())
                .reference(item.getReference())
                .isTrendToday(item.isTrendToday())
                .price(item.getPrice())
                .quantityInStock(item.getQuantityInStock())
                .build();
    }

    public  static List<ItemRetrieveResponse> of(List<Item> items) {
        return items.stream()
                .map(ItemRetrieveResponse::of)
                .toList();
    }
}
