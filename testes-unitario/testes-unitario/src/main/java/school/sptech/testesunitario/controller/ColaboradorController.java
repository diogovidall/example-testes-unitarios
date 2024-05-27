package school.sptech.testesunitario.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.testesunitario.entity.Colaborador;
import school.sptech.testesunitario.service.ColaboradorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/colaboradores")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @GetMapping
    public ResponseEntity<List<Colaborador>> list() {
        List<Colaborador> all = colaboradorService.findAll();

        if (all.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(colaboradorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Colaborador> save(@RequestBody @Valid Colaborador colaborador) {
        return ResponseEntity.ok(colaboradorService.save(colaborador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        colaboradorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
