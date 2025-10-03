package br.edu.infnet.webapi.model.repository;


import br.edu.infnet.webapi.model.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findAddressById(Long id);

}
