package magic.vente.stock.fixtures;

import magic.vente.stock.dto.response.RetrieveManyResponse;
import magic.vente.stock.dto.response.ItemRetrieveResponse;

import java.util.List;

public class ItemResponseFixture {
    public static RetrieveManyResponse<ItemRetrieveResponse> itemRetrieveResponseRetrieveManyResponse;
    public static ItemRetrieveResponse itemRetrieveResponse;

    static {
        itemRetrieveResponse = ItemRetrieveResponse.builder()
                .id(1L)
                .reference("ref")
                .price(100.0)
                .label("Precious Ring")
                .image("https://example.com/image.jpg")
                .dailyImage("https://example.com/daily-image.jpg")
                .quantityInStock(10)
                .build();

        itemRetrieveResponseRetrieveManyResponse = RetrieveManyResponse.<ItemRetrieveResponse>builder()
                .content(
                        List.of(
                                itemRetrieveResponse
                        )
                )
                .limit(10)
                .totalOfElements(1)
                .offset(0)
                .datasetResultCount(1)
                .build();
    }
}
