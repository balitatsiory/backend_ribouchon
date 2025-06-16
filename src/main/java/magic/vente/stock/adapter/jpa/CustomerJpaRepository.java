package magic.vente.stock.adapter.jpa;

import magic.vente.stock.adapter.data.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerJpaRepository extends JpaRepository<CustomerData, Long> {

    Optional<CustomerData> findByUsername(String username);
}
