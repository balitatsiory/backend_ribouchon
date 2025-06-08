package magic.vente.stock.controller;

import lombok.RequiredArgsConstructor;
import magic.vente.stock.domain.service.ItemRetrieveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemRetrieveService itemRetrieveService;

    @GetMapping
    public ResponseEntity retrieveAllItems() {
        return itemRetrieveService.retrieveAll(
            Map.of(), // Assuming no filters are applied for simplicity
            10, // Default limit
            0 // Default offset
        );
    }
}
