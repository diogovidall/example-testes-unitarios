package school.sptech.testesunitario.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraImpostoServiceTest {

    @Test
    @DisplayName("Calcular INSS quando acinado com valor 2.000 deve retornar 200")
    void calcularInssQuandoAcionadoComValor2000DeveRetornar200(){

        /*
            TÉCNICAS DE ORGANIZAÇÃO
            A's Arrange, Act and Assert
         */

        //Arrange
        CalculadoraImpostoService service = new CalculadoraImpostoService();
        var salarioEnviado = 2_000.0;
        var impostoEsperado = 200.0;

        //Act
        var impostoCalculado = service.calcularInss(salarioEnviado);

        //Assert
        assertEquals(impostoEsperado, impostoCalculado);

    }

    @Test
    @DisplayName("Calcular INSS quando acionado com 3.000 deve retornar 450")
    void calcularInssQuandoAcionadoComValor3000DeveRetornar450() {

        //Arrange
        var salarioEnviado = 3_000.0;
        var impostoEsperado = 450.0;

        CalculadoraImpostoService service = new CalculadoraImpostoService();

        //Act
        double impostoCalculado = service.calcularInss(salarioEnviado);

        //Assert
        assertEquals(impostoEsperado, impostoCalculado);
    }

    @Test
    @DisplayName("Calcular INSS quando acionado com valor 500 deve lançar IllegalArgumentException")
    void calcularInssQuandoAcionadoComValor500DeveLancarIllegalArgumentException(){
        //Arrange
        CalculadoraImpostoService service = new CalculadoraImpostoService();
        var salarioInformado = 500.0;
        var mensagemEsperada = "Salário não pode ser que o salário minimo.";

        //Act
        //Assert
       IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.calcularInss(salarioInformado);
        });

        var mensagemObtida = exception.getMessage();

        assertEquals(mensagemEsperada, mensagemObtida);
    }

    @Test
    void calcularInssQuandoAcionadoComSalarioMinimoNaoDeveLancarIllegalArgumentException() {
        CalculadoraImpostoService service = new CalculadoraImpostoService();

        double salarioMinimo = service.SALARIO_MINIMO;

        assertDoesNotThrow(() -> {
            service.calcularInss(salarioMinimo);
        });
    }
}