package br.com.codenation.calculadora;


public class CalculadoraSalario {
    private static final double INSS_1 = 0.08;
    private static final double INSS_2 = 0.09;
    private static final double INSS_3 = 0.11;
    private static final double IRRF_1 = 0.075;
    private static final double IRRF_2 = 0.15;

    public long calcularSalarioLiquido(double salarioBase) {
        validarSalario(salarioBase);
        double salarioFinal = realizarCalculoInss(salarioBase);
        return Math.round(realizarCalculoIrff(salarioFinal));
    }

    private double realizarCalculoInss(double salarioBase) {
        if(salarioBase <= 1500.00){
            return salarioBase - (salarioBase * INSS_1);
        }else if(salarioBase <= 4000.00){
            return salarioBase - (salarioBase * INSS_2);
        }else {
            return salarioBase - (salarioBase * INSS_3);
        }
    }
    private double realizarCalculoIrff(double salarioBase) {
        if (!verificarIrrf(salarioBase)) {
            if (salarioBase <= 3000) {
                return salarioBase;
            } else if (salarioBase <= 6000) {
                return salarioBase - (salarioBase * IRRF_1);
            } else {
                return salarioBase - (salarioBase * IRRF_2);
            }
        }else {
            return 0.00;
        }
    }
    private boolean verificarIrrf(double salariobase) {
        return salariobase <= 1039.00;
    }

    private void validarSalario(Double salarioBase) throws NullPointerException {
        if (salarioBase == null) throw new NullPointerException();
    }

}
