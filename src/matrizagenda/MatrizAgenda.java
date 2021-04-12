
package matrizagenda;

import java.util.Scanner;

/**
 * @author @RafaRodrigues1
 */

public class MatrizAgenda {
    
    public static String menuRetorno(String acao){
        System.out.print("Deseja " + acao + " mais algum compromisso?[S/N] ");
        String resp=new Scanner(System.in).next();
        return resp;
    }
    
    public static void avisoErro(){
        System.out.println("INSIRA DADOS VÁLIDOS! Dia(1 a 31) Hora(0 a 24)");      
    }
    
    public static String[][] insere(String agenda[][]){
        Scanner input = new Scanner(System.in);
        System.out.print("Em que dia deseja inserir o compromisso? ");
        int dia = input.nextInt();
        System.out.print("Em que hora deseja inserir o compromisso? ");
        int hora = input.nextInt();
        if(dia>=1 && dia<=31 && hora>=0 && hora<=24){
            System.out.print("Digite seu compromisso: ");
            agenda[dia-1][hora] = input.next();
        }else{avisoErro();}
        return agenda;
    }
    
    public static void consulta(String agenda[][]){
        Scanner input = new Scanner(System.in);
        System.out.print("Qual dia deseja consultar? ");
        int dia = input.nextInt();
        System.out.print("Qual horário deseja consultar? (Digite 24 para consulta do dia inteiro) ");
        int hora = input.nextInt();
        if(hora==24){                        
            for(int j = 0; j < agenda[dia].length; j++){
                if(!(agenda[dia-1][j].equals("Sem compromisso"))){
                    System.out.println("Compromisso do dia " + dia + 
                    " às " + j + " horas: " + agenda[dia-1][j]);
                }
            }                       
        }else if(dia>=1 && dia<=31 && hora>=0 && hora<=24){   
            System.out.println("Compromisso do dia " + dia + 
            " às " + hora + " horas: " + agenda[dia-1][hora]);
        }else{avisoErro();}                   
    }
       
    public static void main(String[] args) {
        String resp, resp2;
        String diaHora[][] = new String[31][24];
        Scanner input = new Scanner(System.in);
        for(int i = 0; i<diaHora.length; i++){
            for(int j = 0; j<diaHora[i].length; j++){
                diaHora[i][j] = "Sem compromisso";
            }
        }        
        do{
            System.out.print("Consultar[C] ou Inserir[I] compromisso?(0 para interromper) ");
            resp = input.next();
            if(resp.toUpperCase().equals("I")){
                do{
                    insere(diaHora);
                    resp2 = menuRetorno("inserir");
                }while(resp2.equals("S"));
            }else if(resp.toUpperCase().equals("C")){
                do{
                    consulta(diaHora);
                    resp2 = menuRetorno("consultar");                    
                }while(resp2.toUpperCase().equals("S"));  
            }    
        }while((resp.toUpperCase().equals("C")) || (resp.toUpperCase().equals("I")));
        System.out.println("Fim de programa");
    }    
}
