package magic.vente.stock.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PageModel<T> {
    private int limit;
    private int offset;
    private long datasetResultCount;
    private long totalOfElements;
    private List<T> content;
}
