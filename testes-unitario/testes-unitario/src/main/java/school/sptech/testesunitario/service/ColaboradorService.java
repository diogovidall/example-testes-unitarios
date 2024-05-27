package school.sptech.testesunitario.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.testesunitario.entity.Colaborador;
import school.sptech.testesunitario.repository.ColaboradorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    public List<Colaborador> findAll() {
        return colaboradorRepository.findAll();
    }

    public Colaborador findById(Integer id) {
        return colaboradorRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador não encontrado")
        );
    }

    public Colaborador save(Colaborador colaborador) {

        if (colaboradorRepository.existsByEmailContainingIgnoreCase(colaborador.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado");
        }

        return colaboradorRepository.save(colaborador);
    }

    public void delete(Integer id) {

        if (!colaboradorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador não encontrado");
        }

        colaboradorRepository.deleteById(id);
    }
}
