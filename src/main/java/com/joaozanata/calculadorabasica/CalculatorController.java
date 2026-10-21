package com.joaozanata.calculadorabasica;

import com.joaozanata.calculadorabasica.model.TipoOperacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    private double number1;
    private TipoOperacao operacaoAtual;
    private boolean newNumber = true;

    @FXML
    private TextField tela;

    @FXML
    public void clicagem(ActionEvent event) {
        Button botaoClicado = (Button) event.getSource();
        processadorClique(botaoClicado.getText());
    }

    public void processadorClique(String valor) {
        if (valor.matches("[0-9.]")) {
            tratarDigito(valor);
        } else if (valor.equals("±")) {
            tratarInversaoSinal();
        }  else if (valor.matches("[√+*/%-]|X²|1/x")) { // Alterado para .matches()
            tratarOperadores(valor);
        } else {
            tratarComandosEspeciais(valor);
        }
    }

    private void tratarDigito(String valor) {
        if (valor.equals(".")) {
            if (newNumber) {
                tela.setText("0.");
                newNumber = false;
            } else if (!tela.getText().contains(".")) {
                tela.appendText(".");
            }
        } else if (newNumber || tela.getText().equals("0")) {
            tela.setText(valor);
            newNumber = false;
        } else {
            tela.appendText(valor);
        }
    }

    private void tratarInversaoSinal() {
        double numeroAtual = Double.parseDouble(tela.getText());
        if (numeroAtual != 0.0) {
            tela.setText(String.valueOf(-numeroAtual));
        }
    }

    private void tratarOperadores(String valor) {
        TipoOperacao op = TipoOperacao.obterPorSimbolo(valor);
        if (op == null) return;

        number1 = Double.parseDouble(tela.getText());

        if (op.precisaSegundoOperando()) {
            operacaoAtual = op;
        } else {
            // Executa na hora se for raiz, quadrado, etc.
            double resultado = op.calcular(number1, 0);
            tela.setText(String.valueOf(resultado));
        }
        newNumber = true;
    }

    private void tratarComandosEspeciais(String valor) {
        switch (valor) {
            case "=":
                if (operacaoAtual == null) return;
                double number2 = Double.parseDouble(tela.getText());
                double resultado = operacaoAtual.calcular(number1, number2);
                tela.setText(String.valueOf(resultado));
                operacaoAtual = null;
                newNumber = true;
                break;
            case "C":
                tela.setText("0");
                number1 = 0;
                operacaoAtual = null;
                newNumber = true;
                break;
            case "CE":
                tela.setText("0");
                newNumber = true;
                break;
            case "Back":
                executarBackspace();
                break;
        }
    }

    private void executarBackspace() {
        if (!tela.getText().isEmpty() && !tela.getText().equals("0")) {
            String newTexto = tela.getText().substring(0, tela.getText().length() - 1);
            if (newTexto.isEmpty() || newTexto.equals("-")) {
                tela.setText("0");
                newNumber = true;
            } else {
                tela.setText(newTexto);
            }
        }
    }
}

