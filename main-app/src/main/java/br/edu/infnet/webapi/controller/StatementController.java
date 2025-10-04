package br.edu.infnet.webapi.controller;


import br.edu.infnet.webapi.model.domain.dto.StatementRequestDTO;
import br.edu.infnet.webapi.model.domain.dto.StatementResponseDTO;
import br.edu.infnet.webapi.model.service.StatementService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/statements")
public class StatementController {

    private final StatementService statementService;

    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<List<StatementResponseDTO>> getStatements() {
        return ResponseEntity.status(HttpStatus.OK).body(statementService.getAllStatements());
    }

    @GetMapping(value="/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<StatementResponseDTO> getStatementById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(statementService.getStatement(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StatementResponseDTO> createStatement(@Valid @RequestBody StatementRequestDTO statement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(statementService.addStatement(statement));
    }

    @DeleteMapping(value="/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteStatement(@PathVariable("id") Long id) {
        statementService.deleteStatement(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
