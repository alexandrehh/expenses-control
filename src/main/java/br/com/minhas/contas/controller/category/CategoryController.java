package br.com.minhas.contas.controller.category;

import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.dtos.category.CategoryIdDto;
import br.com.minhas.contas.dtos.month.MonthIdDto;
import br.com.minhas.contas.services.category.CategoryService;
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
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Transactional(readOnly = true)
    @GetMapping("/api/getCategory")
    public ResponseEntity<CategoryDto> getCategory(@RequestBody @Valid CategoryIdDto request) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategory(request.getCategoryId()));
    }

    @Transactional(readOnly = true)
    @GetMapping("/api/getCategories")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategories());
    }

    @Transactional(readOnly = true)
    @GetMapping("/api/getCategoriesByMonthId")
    public ResponseEntity<List<CategoryDto>> getCategoriesByMonthId(@RequestBody @Valid MonthIdDto request) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoriesByMonthId(request.getMonthId()));
    }
}
