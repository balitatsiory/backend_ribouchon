package magic.vente.stock.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import magic.vente.stock.domain.service.ItemRetrieveService;
import magic.vente.stock.dto.response.ItemRetrieveResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemRetrieveService itemRetrieveService;

    @GetMapping
    @Operation(summary = "Retrieve all items with pagination")
    public ResponseEntity retrieveAllItems(
            @RequestParam(name = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset
    ) {
        return itemRetrieveService.retrieveAll(
            Map.of(),
            limit,
            offset
        );
    }

    @GetMapping("/dailyItem")
    @Operation(summary = "Retrieve the daily item")
    public ResponseEntity<ItemRetrieveResponse> retrieveDailyItem() {
        return itemRetrieveService.retrieveDailyItem();
    }
}
