package br.edu.infnet.webapi.controller;

import br.edu.infnet.webapi.model.domain.dto.SellerRequestDTO;
import br.edu.infnet.webapi.model.domain.dto.SellerResponseDTO;
import br.edu.infnet.webapi.model.service.SellerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/sellers")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<SellerResponseDTO>> getAllSellers() {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.getSellers());
    }

    @GetMapping(value="/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<SellerResponseDTO> getSellerById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.getSeller(id));
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SellerResponseDTO> addSeller(@Valid @RequestBody SellerRequestDTO seller) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.addSeller(seller));
    }

    @PutMapping(value="/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SellerResponseDTO> updateSeller(@Valid @RequestBody SellerRequestDTO seller) {
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.updateSeller(seller));
    }

    @DeleteMapping(value="/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteSeller(@PathVariable("id") Long id) {
        sellerService.deleteSeller(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
