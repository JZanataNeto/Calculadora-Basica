package com.joaozanata.calculadorabasica.model;


import java.util.HashMap;
import java.util.Map;


public enum TipoOperacao implements Operacao {
    ADICAO("+", true) {
        public double calcular(double n1, double n2) { return n1 + n2; }
    },
    SUBTRACAO("-", true) {
        public double calcular(double n1, double n2) { return n1 - n2; }
    },
    MULTIPLICACAO("*", true) {
        public double calcular(double n1, double n2) { return n1 * n2; }
    },
    DIVISAO("/", true) {
        public double calcular(double n1, double n2) { return n2 == 0 ? 0 : n1 / n2; }
    },
    PORCENTAGEM("%", true) {
        public double calcular(double n1, double n2) { return (n1 * n2) / 100.0; }
    },
    RAIZ("√", false) {
        public double calcular(double n1, double n2) { return Math.sqrt(n1); }
    },
    QUADRADO("X²", false) {
        public double calcular(double n1, double n2) { return n1 * n1; }
    },
    INVERSO("1/x", false) {
        public double calcular(double n1, double n2) { return n1 == 0 ? 0 : 1.0 / n1; }
    };

    private final String simbolo;
    private final boolean precisaSegundoOperando;

    TipoOperacao(String simbolo, boolean precisaSegundoOperando) {
        this.simbolo = simbolo;
        this.precisaSegundoOperando = precisaSegundoOperando;
    }

    public boolean precisaSegundoOperando() { return precisaSegundoOperando; }

    // Busca rápida do Enum pelo símbolo do botão
    private static final Map<String, TipoOperacao> MAPA = new HashMap<>();
    static {
        for (TipoOperacao op : values()) {
            MAPA.put(op.simbolo, op);
        }
    }

    public static TipoOperacao obterPorSimbolo(String simbolo) {
        return MAPA.get(simbolo);
    }
}
