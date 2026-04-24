# Planejador de Viagem (Java + JOptionPane)

## Descrição

Este projeto é um programa em Java que utiliza JOptionPane para criar uma interface gráfica simples.

O objetivo é permitir que o usuário planeje uma viagem informando dados básicos e receber cálculos automáticos sobre datas e custos.

---

## Funcionalidades

### Menu inicial

O programa apresenta duas opções:

**1. Planejar viagem**

**2. Sair**

Entradas inválidas são tratadas para evitar erros.

---

## Entrada de dados

O usuário deve informar:

- Nome (não pode ser vazio)
- Data da viagem no formato: dd,mm,aaaa
- Quantidade de dias da viagem (inteiro positivo)
- Valor gasto por dia (número decimal)

---

## Validações

O sistema impede:

- Campos vazios  
- Valores negativos  
- Entrada de texto inválido  

Validação usando regex:

- Inteiros:
  - \d+

- Decimais:
  - \d+(.\d+)?

---

## Cálculo de datas

O programa utiliza:

- LocalDate  
- ChronoUnit.DAYS  

Para calcular a diferença entre a data atual e a data informada.

---

## Situações tratadas

O sistema identifica três cenários:

### Viagem futura

- Mostra quantos dias faltam  
- Calcula o custo total estimado  

### Viagem no dia atual

- Informa que a viagem é hoje  
- Mostra o custo total  

### Viagem passada

- Mostra há quantos dias ocorreu  
- Converte valores negativos usando:
  - Math.abs()

---

## Cálculo de custos

  - O total da viagem é calculado com:
    - total = quantidadeDias * valorPorDia

  - O valor é formatado com duas casas decimais usando DecimalFormat.

---

## Estrutura do código

Métodos principais:

- main() → inicia o programa  
- iniciando() → mensagem inicial  
- menuBase() → controla o menu  
- resultadosMenu() → lógica principal  
- finaliza() → encerra o programa  

---

## Tecnologias utilizadas

- Java  
- JOptionPane  
- LocalDate  
- ChronoUnit  
- DecimalFormat  

---

## Observações

- Projeto voltado para iniciantes  
- Interface totalmente gráfica (sem console)  
- O programa encerra após execução  

---

## Melhorias futuras

- Permitir formato de data com "/"
- Uso de try/catch para evitar erros de conversão
- Loop para múltiplos planejamentos
- Interface mais avançada (Swing ou JavaFX)

---

## Como executar

  - Compile:
    - javac Main_Planejador.java
  - Execute:
    - java Main_Planejador

---

## Autor

Projeto desenvolvido para fins de estudo em Java.
