package school.sptech.testesunitario.service;

public class CalculadoraImpostoService {

    public static final double SALARIO_MINIMO = 1_000.0;

    public double calcularInss(double salario){

        if (salario < SALARIO_MINIMO){
            throw new IllegalArgumentException("Salário não pode ser que o salário minimo.");
        }

        var impostoBase = 0.2;

        if (salario <= 2_000.0){
            impostoBase = 0.1;

        } else if (salario >= 2_000.0 || salario <= 3_000.0) {
            impostoBase = 0.15;
        }
        return salario * impostoBase;
    }
}
