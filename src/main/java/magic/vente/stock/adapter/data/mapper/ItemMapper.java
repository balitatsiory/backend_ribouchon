package magic.vente.stock.adapter.data.mapper;

import magic.vente.stock.adapter.data.ItemData;
import magic.vente.stock.domain.model.Item;

import java.util.List;

public class ItemMapper {
    public static Item toDomain(ItemData itemData){
        return Item.builder()
                .id(itemData.getId())
                .name(itemData.getName())
                .description(itemData.getDescription())
                .build();
    }

    public static List<Item> toDomainList(List<ItemData> content) {
        return content.stream().map(ItemMapper::toDomain).toList();
    }
}
