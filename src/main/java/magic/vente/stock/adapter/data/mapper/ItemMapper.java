package magic.vente.stock.adapter.data.mapper;

import magic.vente.stock.adapter.data.ItemData;
import magic.vente.stock.domain.model.Item;

import java.util.List;

public class ItemMapper {
    public static Item toDomain(ItemData itemData){
        return Item.builder()
                .id(itemData.getId())
                .label(itemData.getLabel())
                .reference(itemData.getReference())
                .quantityInStock(itemData.getQuantityInStock())
                .isTrendToday(itemData.isTrendToday())
                .price(itemData.getPrice())
                .img(itemData.getImg())
                .dailyImage(itemData.getDailyImage())
                .build();
    }

    public static ItemData toData(Item item) {
        return ItemData.builder()
                .id(item.getId())
                .label(item.getLabel())
                .reference(item.getReference())
                .quantityInStock(item.getQuantityInStock())
                .isTrendToday(item.isTrendToday())
                .price(item.getPrice())
                .img(item.getImg())
                .dailyImage(item.getDailyImage())
                .build();
    }

    public static List<Item> toDomainList(List<ItemData> content) {
        return content.stream().map(ItemMapper::toDomain).toList();
    }
}
