package magic.vente.stock.port;

import magic.vente.stock.domain.model.Item;
import magic.vente.stock.domain.model.PageModel;

import java.time.LocalDate;
import java.util.Map;

public interface ItemPort {
    PageModel<Item> retrieveAll(Map<String,String> filters, int limit, int offset);
    void create(Item item);
    void update(int id,Item itemUpdate);
    Item retrieveOne(int id);

    Item retrieveDailyItem(LocalDate today);
}
