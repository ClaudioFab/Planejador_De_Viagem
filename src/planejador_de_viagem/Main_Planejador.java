
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
    //Mensagem inicial.
    public static void iniciando(){
        JOptionPane.showMessageDialog(null,"04.0 - JOptionPane - Planejador de Viagem\n","Iniciando",JOptionPane.INFORMATION_MESSAGE);
    }    
    //Menu inicial com Planejar viagem/Sair.
    public static int menuBase(int valor){
        int m01=0;        
        //Valores negativos e Campos vazios não são permitidos.
        do {  
            String menu = JOptionPane.showInputDialog(null,"(1) Planejar viagem\n\n(2) Sair\n\nEscolha a opção desejada.","Menu de Planejamento",JOptionPane.INFORMATION_MESSAGE);
            if (menu == null) {
                finaliza();
            }else if(menu.isEmpty()){
                JOptionPane.showMessageDialog(null,"Entrada inválida!\nUtilize apenas Números do Menu!","Erro",JOptionPane.ERROR_MESSAGE);
            }else if(menu.matches("\\d+")) {
                m01 = Integer.parseInt(menu);
                switch (m01) {
                    case 1:
                        m01 =1;
                        break;
                    case 2:
                        m01 =2;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Entrada inválida!\nUtilize apenas Números do Menu!","Erro",JOptionPane.ERROR_MESSAGE);
                        continue;
                }
                break;
            }else{
                JOptionPane.showMessageDialog(null,"Entrada inválida!\nUtilize apenas Números do Menu!","Erro",JOptionPane.ERROR_MESSAGE);
            }
        } while (true);
        return m01;
    }
    //Opção Planejar viagem do Menu.
    public static void resultadosMenu(int valor){
        LocalDate dataAtual = LocalDate.now();
        DecimalFormat df2 = new DecimalFormat("0.00");
        //Pegando data atual.
        int anoAtual = dataAtual.getYear();
        int mesAtual = dataAtual.getMonthValue();
        int diaAtual = dataAtual.getDayOfMonth();
        if(valor == 1){            
            //pedir nome do viajante .
            String nome;
            do {                
                nome = JOptionPane.showInputDialog(null,"Nome: ","Informar Nome",JOptionPane.QUESTION_MESSAGE);
                //Escolha Cancel nome.
                if (nome == null) {
                    finaliza();
                //Escolha deixar vazio nome.
                }else if(nome.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Entrada inválida!\nDigite um nome.","Erro",JOptionPane.ERROR_MESSAGE);
                }else{
                    break;
                }                
            } while (true);   
            //pedir data da viagem no formato dd/MM/yyyy.
            String dataUser;
            do {                
                dataUser = JOptionPane.showInputDialog(null,"Informe a Data da Viagem:\nDIA, MÊS e ANO (dd , mm , aaaa)","Informar Data da Viagem",JOptionPane.QUESTION_MESSAGE);
                //Escolha Cancel nome.
                if (dataUser == null) {
                    finaliza();
                //Escolha deixar vazio nome.
                }else if(dataUser.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Entrada inválida!\nDigite uma data.","Erro",JOptionPane.ERROR_MESSAGE);
                }else{
                    break;
                }                
            } while (true);
            //Converter String para dias separados.
            String[] partes = dataUser.split(",");
            int diaMarcar = Integer.parseInt(partes[0]);
            int mesMarcar = Integer.parseInt(partes[1]);
            int anoMarcar = Integer.parseInt(partes[2]);
            //Converter String para LocalDate.
            LocalDate dataFutura = LocalDate.of(anoMarcar, mesMarcar, diaMarcar);
            // Calcular diferença em dias
            long diasResto = ChronoUnit.DAYS.between(dataAtual, dataFutura);
            //pedir duração da viagem.
            int qntDias=0;
            //Valores negativos e Campos vazios não são permitidos.
            do {  
                String quantidadeDia = JOptionPane.showInputDialog(null,"Informar a duração da viagem em dias","Informar Tempo",JOptionPane.QUESTION_MESSAGE);
                if (quantidadeDia == null) {
                    finaliza();
                }else if(quantidadeDia.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Entrada inválida!\nUtilize apenas Números!","Erro",JOptionPane.ERROR_MESSAGE);
                }else if(quantidadeDia.matches("\\d+")) {
                    qntDias = Integer.parseInt(quantidadeDia);
                    if(qntDias <=0){
                        JOptionPane.showMessageDialog(null,"Entrada inválida!\nUtilize apenas um número de dias igual ou maior a 1.","Erro",JOptionPane.ERROR_MESSAGE);
                        continue;
                    }else{
                        qntDias = Integer.parseInt(quantidadeDia);
                        break;
                    } 

                }else{
                    JOptionPane.showMessageDialog(null,"Entrada inválida!\nUtilize apenas Números!","Erro",JOptionPane.ERROR_MESSAGE);
                }
            } while (true);
            
            
            
            
            
            
            ///////////////////////////////PROBLEMA///////////////////////////////
            //pedir valor gasto por dia.
            double valorDia=0.0;
            //Valores negativos e Campos vazios não são permitidos.
            do {  
                String quantidadeGasto = JOptionPane.showInputDialog(null,"Informar o valor gasto por dia","Informar Gasto",JOptionPane.QUESTION_MESSAGE);
                if (quantidadeGasto == null) {
                    finaliza();
                }else if(quantidadeGasto.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Entrada inválida!\nUtilize apenas Números!","Erro",JOptionPane.ERROR_MESSAGE);
                }else if(quantidadeGasto.matches("\\d+")) {
                    valorDia = Double.parseDouble(quantidadeGasto);
                    break;
                }else{
                    JOptionPane.showMessageDialog(null,"Entrada inválida!\nUtilize apenas Números!","Erro",JOptionPane.ERROR_MESSAGE);
                }
            } while (true);
            ///////////////////////////////PROBLEMA///////////////////////////////


            
            
            
            
            
            //Painel de planejamento do Usuário.
            JOptionPane.showMessageDialog(null,"Usuário: "+nome+"\n\nData da viagem: ("+diaMarcar+" / "+mesMarcar+" / "+anoMarcar+")\n"
                    + "Duração da viagem: "+qntDias+" dias.\nValor gasto por dia: R$ "+df2.format(valorDia),"Planejamento do Usuário ("+diaAtual+"/"+mesAtual+"/"+anoAtual+")",JOptionPane.INFORMATION_MESSAGE);
            //Verificar se a viagem é Futura.
            if(diasResto > 0){
                JOptionPane.showMessageDialog(null,nome+" sua viagem será em ("+diaMarcar+" / "+mesMarcar+" / "+anoMarcar+")\n"
                    +"Faltam "+diasResto+" dias.\nTotal estimado para os "+qntDias+" dia(s): R$ "+df2.format(qntDias*valorDia),"Informação de viagem ("+diaAtual+"/"+mesAtual+"/"+anoAtual+")",JOptionPane.INFORMATION_MESSAGE);            
            //Verificar se a viagem é Hoje.
            }else if(diasResto == 0){
                JOptionPane.showMessageDialog(null,nome+" sua viagem será (Hoje "+diaAtual+"/"+mesAtual+"/"+anoAtual+")\nTotal estimado para os "+qntDias+" dia(s): R$ "+df2.format(qntDias*valorDia),"Informação de viagem ("+diaAtual+"/"+mesAtual+"/"+anoAtual+")",JOptionPane.INFORMATION_MESSAGE);   
            //Verificar se a viagem é Passada.
            }else if(diasResto < 0){
                //convertendo dias negativos para positivos.
                diasResto = Math.abs(diasResto);                
                JOptionPane.showMessageDialog(null,nome+" a data da viagem foi em ("+diaMarcar+" / "+mesMarcar+" / "+anoMarcar+")\n"
                    +"Ocorreu a "+diasResto+" dia(s) atrás.","Informação de viagem ("+diaAtual+"/"+mesAtual+"/"+anoAtual+")",JOptionPane.INFORMATION_MESSAGE);   
            }
        //Opção Sair do Menu.
        }else if(valor == 2){
            finaliza();  
        }
        finaliza();
    }
    //Função de finalizar.
    public static void finaliza(){
        JOptionPane.showMessageDialog(null,"Programa finalizado.","Encerrando",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }  
}
