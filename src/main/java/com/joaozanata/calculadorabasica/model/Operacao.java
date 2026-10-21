package com.joaozanata.calculadorabasica.model;

public interface Operacao {
    // Para operações de dois números (ex: +, -, *, /)
    double calcular(double num1, double num2);

    // Identifica se a operação precisa de um segundo número (true) ou é instantânea (false, ex: √, X²)
    boolean precisaSegundoOperando();
}
