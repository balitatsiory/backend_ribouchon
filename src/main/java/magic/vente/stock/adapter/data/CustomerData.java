package magic.vente.stock.adapter.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client")
    private Long id;
    @Column(unique = true,name = "pseudo")
    private String username;
    @Column(name = "mot_de_passe")
    private String password;
}
