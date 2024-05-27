package school.sptech.testesunitario.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import school.sptech.testesunitario.entity.Colaborador;
import school.sptech.testesunitario.repository.ColaboradorRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ColaboradorServiceTest {

    @Mock
    ColaboradorRepository repository;

    @InjectMocks
    ColaboradorService service;

    @Test
    @DisplayName("Quando acionado deve retornar lista vazia")
    void findAllQuandoAcionadoETabelaEstaVaziaDeveRetornarListaVazia(){
        var tamanhoEsperado = 0;

        Mockito.when(repository.findAll()).thenReturn(Collections.emptyList());

        List<Colaborador> colaboradores = service.findAll();

        assertEquals(tamanhoEsperado, colaboradores.size());
    }

    @Test
    @DisplayName("Quando acionado deve retornar 3 colaboradores")
        //Given
        void findAllQuandoAcionadoDeveRetorna3Colaboradores(){
        var colaboradoresEsperados = List.of(
                new Colaborador(),
                new Colaborador(),
                new Colaborador()
        );

        Mockito.when(repository.findAll()).thenReturn(colaboradoresEsperados);

        List<Colaborador> todos = service.findAll();

        assertEquals(colaboradoresEsperados.size(), todos.size());
    }


}