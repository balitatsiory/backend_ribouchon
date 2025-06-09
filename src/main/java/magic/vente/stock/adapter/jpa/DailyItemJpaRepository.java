package magic.vente.stock.adapter.jpa;

import magic.vente.stock.adapter.data.DailyItemData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyItemJpaRepository extends JpaRepository<DailyItemData,Long> {
}
