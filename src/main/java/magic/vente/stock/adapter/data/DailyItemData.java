package magic.vente.stock.adapter.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "produit_du_jour")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DailyItemData {
    @Id
    @Column(name="id_produit_du_jour")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produit")
    private ItemData item;
    private LocalDate date;
}
