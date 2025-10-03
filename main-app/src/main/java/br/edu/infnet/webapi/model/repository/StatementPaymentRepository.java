package br.edu.infnet.webapi.model.repository;

import br.edu.infnet.webapi.model.domain.StatementPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementPaymentRepository extends JpaRepository<StatementPayment, Long> {
}
