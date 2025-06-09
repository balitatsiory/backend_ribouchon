package magic.vente.stock.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Item {
    private long id;
    private String label;
    private String reference;
    private String imageUrl;
    private String dailyTrendImage;
    private double price;
    private int quantityInStock;
    private String img;
    private String dailyImage;
}
