package magic.vente.stock.adapter.jpa;

import magic.vente.stock.adapter.data.ItemData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface ItemJpaRepository extends JpaRepository<ItemData,Long>, JpaSpecificationExecutor<ItemData> {
    @Query("SELECT i FROM ItemData i JOIN DailyItemData d ON i.id = d.item.id WHERE d.date = :date")
    Optional<ItemData> findDailyItem(LocalDate date );
}
