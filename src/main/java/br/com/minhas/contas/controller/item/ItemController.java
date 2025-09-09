package br.com.minhas.contas.controller.item;

import br.com.minhas.contas.dtos.category.CategoryIdDto;
import br.com.minhas.contas.dtos.item.ItemDto;
import br.com.minhas.contas.dtos.item.ItemIdDto;
import br.com.minhas.contas.services.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Transactional(readOnly = true)
    @GetMapping("/api/getItem")
    public ResponseEntity<ItemDto> getItem(@RequestBody @Valid ItemIdDto request) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getItem(request.getItemId()));
    }

    @Transactional(readOnly = true)
    @GetMapping("/api/getItems")
    public ResponseEntity<List<ItemDto>> getItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getItems());
    }

    @Transactional(readOnly = true)
    @GetMapping("/api/getItemsByCategoryId")
    public ResponseEntity<List<ItemDto>> getItemsByCategoryId(@RequestBody @Valid CategoryIdDto request) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getItemsByCategoryId(request.getCategoryId()));
    }
}
