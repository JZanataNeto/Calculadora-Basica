# 🧮 Calculadora Básica em Java

Uma calculadora simples desenvolvida em **Java** que executa as oito operações matemáticas básicas. Projeto ideal para praticar lógica de programação e sintaxe da linguagem.

## 🚀 Funcionalidades

*   **Soma** (+)
*   **Subtração** (-)
*   **Multiplicação** (*)
*   **Divisão** (/) (com validação para evitar divisão por zero)
*   **Inversão** (1/x)
*   **Porcetagem** (%)
*   **Raiz quadrada** (√)
*   **Potência de dois** (x²)
*   **Inversão de Sinal** (±)
*   **Botão de cancelar entrada** (CE)
*   **Botão de limpar** (C)
*   **Botão Backspace** (Back)
*   **Inserção de Dot** (.)

## 🛠️ Tecnologias

*   **Java** (Versão 26)
*   **JavaFX** (para desenvolver interfaces gráficas)
*   **Scene Builder** (para geração do arquivo FXML)

## Lógicas e validações  
A variável **newNumber** serve como um flag (sinalizador) para indicar se o próximo dígito inserido deve iniciar um novo número na tela ou deve anexar-se ao número que já está na tela.
Se for **newNumber = true**: O próximo número clicado substitui o completamente o texto atual, quando um botão operador for clicado, ou quando o botão "=" for pressionado, ou, ainda, quando os botões de limpeza forem ativados (C, CE).
Se for **newNumber = false**, o próximo número clicado é anexado ao fim do número que já está na tela, quando o usuário clicar em um botão numérico, a flag altera para false, permitindo ao usuário a continuidade da digitação.

## 📦 Como Executar

1. Clone o repositório:
     
   https://git@github.com:JZanataNeto/Calculadora-Basica.git
    
3. Acesse a pasta do projeto:
   ```bash
   cd nome-do-repositorio
   ```
4. Compile o arquivo fonte:
   ```bash
   javac Main.java
   ```
5. Execute o programa:
   ```bash
   java Main
   ```

## 📝 Design e Layout
<img src="src/main/resources/com/joaozanata/calculadorabasica/calculadora-img.png.png" alt="foto calculadora" width="201" height="315">



