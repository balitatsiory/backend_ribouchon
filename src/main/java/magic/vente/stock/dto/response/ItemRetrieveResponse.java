package magic.vente.stock.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import magic.vente.stock.domain.model.Item;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemRetrieveResponse {
    private long id;
    private String label;
    private String reference;
    private boolean isTrendToday;
    private double price;
    private int quantityInStock;
    private String image;
    private String dailyImage;


    public static ItemRetrieveResponse of(Item item) {
        return ItemRetrieveResponse.builder()
                .id(item.getId())
                .label(item.getLabel())
                .reference(item.getReference())
                .isTrendToday(item.isTrendToday())
                .price(item.getPrice())
                .image(item.getImg())
                .dailyImage(item.getDailyImage())
                .quantityInStock(item.getQuantityInStock())
                .build();
    }

    public  static List<ItemRetrieveResponse> of(List<Item> items) {
        return items.stream()
                .map(ItemRetrieveResponse::of)
                .toList();
    }
}
