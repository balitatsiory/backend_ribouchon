package magic.vente.stock.controller;

import lombok.RequiredArgsConstructor;
import magic.vente.stock.domain.service.ItemRetrieveService;
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
}
