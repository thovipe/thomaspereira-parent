package br.edu.infnet.webapi.model.repository;

import br.edu.infnet.webapi.model.domain.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepository extends JpaRepository<Statement, Long> {
}
