package br.com.softwalter.med.api.doumain.entities.repositories;

import br.com.softwalter.med.api.doumain.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
