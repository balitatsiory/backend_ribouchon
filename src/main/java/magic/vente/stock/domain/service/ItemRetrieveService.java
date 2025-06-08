package magic.vente.stock.domain.service;

import lombok.RequiredArgsConstructor;
import magic.vente.stock.domain.model.Item;
import magic.vente.stock.domain.model.PageModel;
import magic.vente.stock.dto.response.ItemRetrieveResponse;
import magic.vente.stock.port.ItemPort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemRetrieveService {
    private final ItemPort itemPort;


    public ResponseEntity<RetrieveManyResponse<ItemRetrieveResponse>> retrieveAll(Map<String,String> filters, int limit, int offset) {
        PageModel<Item> pagedItem = itemPort.retrieveAll(filters, limit, offset);
        RetrieveManyResponse<ItemRetrieveResponse> retrieveManyResponse = RetrieveManyResponse
                .<ItemRetrieveResponse>builder()
                .limit(limit)
                .offset(offset)
                .datasetResultCount(pagedItem.getDatasetResultCount())
                .totalOfElements(pagedItem.getTotalOfElements())
                .content(ItemRetrieveResponse.of(pagedItem.getContent()))
                .build();
        return ResponseEntity.ok(retrieveManyResponse);
    }
}

