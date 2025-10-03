package br.edu.infnet.webapi.model.repository;

import br.edu.infnet.webapi.model.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository <Seller, Long>{

    Optional<Seller> findSellerById(long Id);
    Optional<Seller> findSellerByCnpj(String cnpj);
}
