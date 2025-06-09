package magic.vente.stock.adapter.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DailyItemData {
    @Id
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private ItemData item;
    private LocalDate date;
}
