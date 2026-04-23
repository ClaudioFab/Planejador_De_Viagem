
/*
Regras do Programa

3. Validar:
Campos vazios
Conversão de números (usar parseInt e parseDouble)/////////
Data válida (usar LocalDate)///////////////////////////////
Valores negativos não são permitidos

*/

package planejador_de_viagem;

import java.time.LocalDate;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.time.temporal.ChronoUnit;
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
            
            //Pegando data atual.
            int anoAtual = dataAtual.getYear();
            int mesAtual = dataAtual.getMonthValue();
            int diaAtual = dataAtual.getDayOfMonth();
            
            //pedir nome.
            String nome = JOptionPane.showInputDialog(null,"Nome: ","Informar Nome",JOptionPane.QUESTION_MESSAGE);

            //pedir data.
            String dataUser = JOptionPane.showInputDialog(null,"Informe a Data da Viagem:\nANO, MÊS e DIA (aaaa , mm , dd)","Informar Data da Viagem",JOptionPane.QUESTION_MESSAGE);

            //Converter String para dias separados.
            String[] partes = dataUser.split(",");
            int anoMarcar = Integer.parseInt(partes[0]);
            int mesMarcar = Integer.parseInt(partes[1]);
            int diaMarcar = Integer.parseInt(partes[2]);

            //Converter String para LocalDate.
            LocalDate dataFutura = LocalDate.of(anoMarcar, mesMarcar, diaMarcar);

            // Calcular diferença em dias
            long diasResto = ChronoUnit.DAYS.between(dataAtual, dataFutura);

            //pedir duração da viagem.
            int qntDias = Integer.parseInt(JOptionPane.showInputDialog(null,"Informar a duração da viagem em dias","Informar Tempo",JOptionPane.QUESTION_MESSAGE));
            double valorDia = Double.parseDouble(JOptionPane.showInputDialog(null,"Informar o valor gasto por dia","Informar Gasto",JOptionPane.QUESTION_MESSAGE));
            //pedir valor gasto.
            JOptionPane.showMessageDialog(null,"Usuário: "+nome+"\n\nData da viagem: ("+diaMarcar+" / "+mesMarcar+" / "+anoMarcar+")\n"
                    + "Duração da viagem: "+qntDias+" dias.\nValor por dia: R$ "+df2.format(valorDia),"Informações de Planejamento do Usuário ("+diaAtual+"/"+mesAtual+"/"+anoAtual+")",JOptionPane.INFORMATION_MESSAGE);

            //Verificar se a viagem é Futura.
            if(diasResto > 0){
                JOptionPane.showMessageDialog(null,nome+" sua viagem será em ("+diaMarcar+" / "+mesMarcar+" / "+anoMarcar+")\n"
                    +"Faltam "+diasResto+" dias.\nTotal estimado para os "+qntDias+" dias: R$ "+df2.format(qntDias*valorDia),"Informação de viagem ("+diaAtual+"/"+mesAtual+"/"+anoAtual+")",JOptionPane.INFORMATION_MESSAGE);
            
            //Verificar se a viagem é Hoje.
            }else if(diasResto == 0){
                JOptionPane.showMessageDialog(null,nome+" sua viagem será (Hoje)\nTotal estimado para os "+qntDias+" dias: R$ "+df2.format(qntDias*valorDia),"Informação de viagem ("+diaAtual+"/"+mesAtual+"/"+anoAtual+")",JOptionPane.INFORMATION_MESSAGE);
   
            //Verificar se a viagem é Passada.
            }else if(diasResto < 0){
                //convertendo dias negativos para positivos.
                diasResto = Math.abs(diasResto);
                
                JOptionPane.showMessageDialog(null,nome+" a data da viagem passada foi em ("+diaMarcar+" / "+mesMarcar+" / "+anoMarcar+")\n"
                    +"Ocorreu a "+diasResto+" dia(s) atrás.","Informação de viagem ("+diaAtual+"/"+mesAtual+"/"+anoAtual+")",JOptionPane.INFORMATION_MESSAGE);
   
            }
 
        }else if(valor == 2){
            finaliza();  
        }
        
        

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void finaliza(){
        JOptionPane.showMessageDialog(null,"Programa finalizado.","Encerrando",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
  
}
