package magic.vente.stock.adapter;

import magic.vente.stock.adapter.data.ItemData;
import magic.vente.stock.adapter.data.mapper.ItemMapper;
import magic.vente.stock.adapter.jpa.ItemJpaRepository;
import magic.vente.stock.domain.model.Item;
import magic.vente.stock.domain.model.PageModel;
import magic.vente.stock.port.ItemPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ItemAdapter implements ItemPort {
    private ItemJpaRepository itemJpaRepository;
    @Override
    public PageModel<Item> retrieveAll(Map<String, String> filters, int limit, int offset) {
        Page<ItemData> itemDataPage = itemJpaRepository.findAll(
                // TODO: add specification
                PageRequest.of(offset, limit)
        );
        return PageModel.<Item>builder()
                .limit(limit)
                .offset(offset)
                .totalOfElements(itemDataPage.getTotalElements())
                .datasetResultCount(itemDataPage.getNumberOfElements())
                .content(ItemMapper.toDomainList(itemDataPage.getContent()))
                .build();
    }

    @Override
    public void create(Item item) {

    }

    @Override
    public void update(int id, Item itemUpdate) {

    }

    @Override
    public Item retrieveOne(int id) {
        return null;
    }
}
