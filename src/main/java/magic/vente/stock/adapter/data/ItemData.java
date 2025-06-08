package magic.vente.stock.adapter.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produits")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemData {
    @Id
    @Column(name = "id_produit")
    private Long id;
    @Column(unique = true)
    private String reference;
    @Column(name = "libelle")
    private String label;
    @Column(name = "est_du_jour")
    private boolean isTrendToday;
    @Column(name = "prix")
    private double price;
    @Column(name = "quantite_en_stock")
    private int quantityInStock;
}
