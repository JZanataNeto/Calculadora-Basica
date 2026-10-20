package com.joaozanata.calculadorabasica;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static java.lang.Math.sqrt;

public class CalculatorController {

    private double number1;
    private String operator = "";
    private boolean newNumber = true;

    @FXML
    private TextField tela;

    public void clicagem(ActionEvent event) {
        Button botaoClicado = (Button) event.getSource();
        processadorClique(botaoClicado.getText());

    }

    public void processadorClique(String valor) {
        // o dot é tratado separadamente para evitar que seja digitado repetidamente.
        if(valor.matches("[0-9.]")) {
            if(valor.equals(".")) {
                if(newNumber) {
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
        } else if (valor.equals("±")) {
            double numeroAtual = Double.parseDouble(tela.getText());
            if (numeroAtual != 0.0) {
                tela.setText(String.valueOf(-numeroAtual));
            }
        } else if (valor.matches("[+*/%√-]|X²|1/x")) {
            number1 = Double.parseDouble(tela.getText());
            operator = valor;
            newNumber = true;
        } else if (valor.equals("=")) {
            if (operator.isEmpty()) return;
            double number2 = Double.parseDouble(tela.getText());
            double resultado = calcular(number1, number2, operator);
            tela.setText(String.valueOf(resultado));
            operator = "";
            newNumber = true;
        } else if (valor.equals("C")) {
            tela.setText("0");
            newNumber = true;
            number1 = 0;
            operator = "";
        } else if (valor.equals("CE")) {
            tela.setText("0");
            newNumber = true;
        } else if (valor.equals("Back")) {
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

    public double calcular(double number1, double number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    return 0;
                } else {
                    return number1 / number2;
                }
            case "√":
                return sqrt(number1);
            case "X²":
                return number1 * number1;
            case "1/x":
                return 1 / number1;
            case "%":
                return number1 * number2 / 100;
            default: return 0;
        }
    }
}
