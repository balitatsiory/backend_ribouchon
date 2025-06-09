package magic.vente.stock.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RetrieveManyResponse<T> {
    private long datasetResultCount;
    private long totalOfElements;
    private int limit;
    private int offset;
    private List<T> content;
}
