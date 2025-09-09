package br.com.minhas.contas.controller.month;

import br.com.minhas.contas.dtos.month.MonthDto;
import br.com.minhas.contas.dtos.month.MonthIdDto;
import br.com.minhas.contas.dtos.month.SaveUpdateMonthDto;
import br.com.minhas.contas.services.month.MonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MonthController {

    @Autowired
    private MonthService monthService;

    @Transactional
    @PostMapping("/api/saveUpdateMonth")
    public ResponseEntity<SaveUpdateMonthDto> saveUpdateMonth(@RequestBody @Valid SaveUpdateMonthDto request) {
        return ResponseEntity.status(HttpStatus.OK).body(monthService.saveUpdateMonth(request));
    }

    @Transactional(readOnly = true)
    @GetMapping("/api/getMonth")
    public ResponseEntity<MonthDto> getMonth(@RequestBody @Valid MonthIdDto request) {
        return ResponseEntity.status(HttpStatus.OK).body(monthService.getMonth(request.getMonthId()));
    }

    @Transactional(readOnly = true)
    @GetMapping("/api/getMonths")
    public ResponseEntity<List<MonthDto>> getMonths() {
        return ResponseEntity.status(HttpStatus.OK).body(monthService.getMonths());
    }

    @Transactional
    @DeleteMapping("/api/deleteMonth")
    public void deleteMonth(@RequestBody @Valid MonthIdDto request) {
        monthService.deleteMonth(request.getMonthId());
    }
}
