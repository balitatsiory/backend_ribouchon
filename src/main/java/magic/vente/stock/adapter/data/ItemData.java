package magic.vente.stock.adapter.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemData {
    @Id
    private Long id;
    private String name;
    private String description;
}
