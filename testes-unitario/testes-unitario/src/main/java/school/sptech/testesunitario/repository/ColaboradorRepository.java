package school.sptech.testesunitario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.testesunitario.entity.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    boolean existsByEmailContainingIgnoreCase(String email);
}
