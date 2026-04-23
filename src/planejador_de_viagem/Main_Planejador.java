
/*
Regras do Programa

1. Exibir um menu inicial:
Planejar viagem////////////////////////////////////////////
Sair///////////////////////////////////////////////////////

2. Solicitar os seguintes dados:
Nome do viajante///////////////////////////////////////////
Data da viagem no formato dd/MM/yyyy///////////////////////
Quantidade de dias de viagem (inteiro)/////////////////////
Valor gasto por dia (decimal)//////////////////////////////

3. Validar:
Campos vazios
Conversão de números (usar parseInt e parseDouble)/////////
Data válida (usar LocalDate)
Valores negativos não são permitidos

4. Processar:
Calcular o valor total da viagem:
total = dias * valorPorDia
Verificar se a viagem é:
Passada
Hoje
Futura
Se for futura, calcular quantos dias faltam

* Exibir resultado:
Nome
Data da viagem
Dias de viagem
Valor total
Situação da viagem (passada, hoje ou futura)

* Exemplo de funcionamento

Entrada:
Nome: Sebastiana
Data: 20/12/2026
Dias: 5
Valor por dia: 150.50

Saída:
Sebastiana, sua viagem será em 20/12/2026
Faltam 40 dias
Total estimado: R$ 752.50
*/

package planejador_de_viagem;

import java.time.LocalDate;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
public class Main_Planejador {

    public static void main(String[] args) {

        iniciando();
        resultadosMenu(menuBase(0));

    }

    public static void iniciando(){
        JOptionPane.showMessageDialog(null,"04.0 - JOptionPane - Planejador de Viagem\n","Iniciando",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int menuBase(int valor){
        int menu = Integer.parseInt(JOptionPane.showInputDialog(null,"(1) Planejar viagem\n\n(2) Sair\n\nEscolha a opção desejada.","Menu de Planejamento",JOptionPane.INFORMATION_MESSAGE));
        return menu;
    }
    
    public static void resultadosMenu(int valor){
        LocalDate dataAtual = LocalDate.now();
        DecimalFormat df2 = new DecimalFormat("0.00");
        if(valor == 1){
            //pedir nome.
            String nome = JOptionPane.showInputDialog(null,"Nome: ","Informar Nome",JOptionPane.QUESTION_MESSAGE);
            //pedir data.
            String data = JOptionPane.showInputDialog(null,"Informe a Data da Viagem:\nDia, Mês e Ano (dd , mm , aaaa)","Informar Data",JOptionPane.QUESTION_MESSAGE);
            String[] partes = data.split(",");
            int diaMarcar = Integer.parseInt(partes[0]);
            int mesMarcar = Integer.parseInt(partes[1]);
            int anoMarcar = Integer.parseInt(partes[2]);
            //pedir duração da viagem.
            int qntDias = Integer.parseInt(JOptionPane.showInputDialog(null,"Informar a duração da viagem em dias","Informar Tempo",JOptionPane.QUESTION_MESSAGE));
            double valorDia = Double.parseDouble(JOptionPane.showInputDialog(null,"Informar o valor gasto por dia","Informar Gasto",JOptionPane.QUESTION_MESSAGE));
            //pedir valor gasto.
            JOptionPane.showMessageDialog(null,"Usuário: "+nome+"\n\nData da viagem: ("+diaMarcar+" / "+mesMarcar+" / "+anoMarcar+")\n"
                    + "Duração da viagem: "+qntDias+" dias.\nValor por dia: R$ "+df2.format(valorDia),"Informações de Usuário",JOptionPane.INFORMATION_MESSAGE);
            
            
            /*
            4. Processar:
            Verificar se a viagem é:
            Passada
            Hoje
            Futura
            Se for futura, calcular quantos dias faltam
            
            Saída:
            Sebastiana, sua viagem será em 20/12/2026
            Faltam 40 dias
            Total estimado: R$ 752.50

            */
            
            int anoAtual = dataAtual.getYear();
            int mesAtual = dataAtual.getMonthValue();
            int diaAtual = dataAtual.getDayOfMonth();
            

 
            JOptionPane.showMessageDialog(null,nome+" sua viagem será em ("+diaMarcar+" / "+mesMarcar+" / "+anoMarcar+")\n"
                    + "Faltam X dias.\nTotal estimado: R$ "+df2.format(qntDias*valorDia));
            

            
        }else if(valor == 2){
            finaliza();  
        }
        
        

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void finaliza(){
        JOptionPane.showMessageDialog(null,"Programa finalizado.","Encerrando",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
  
}
