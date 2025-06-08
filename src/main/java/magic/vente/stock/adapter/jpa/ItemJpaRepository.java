package magic.vente.stock.adapter.jpa;

import magic.vente.stock.adapter.data.ItemData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemJpaRepository extends JpaRepository<ItemData,Long>, JpaSpecificationExecutor<ItemData> {
}
