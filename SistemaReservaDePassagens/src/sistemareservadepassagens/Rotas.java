
package sistemareservadepassagens;

import java.util.Scanner;
import java.util.Random;

public class Rotas {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int id;
    private String origem;    
    private String parada;    
    private String destino;
    private Hora horario_saida;  
    private Hora horario_chegada;
    private int valor_passagem;
    private Onibus onibus;

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }
         
    public Rotas() {
    }
    
    public Rotas(String origem, String parada, String destino, Hora horario_saida, Hora horario_chegada, int valor_passagem) {
        this.origem = origem;
        this.parada = parada;
        this.destino = destino;
        this.horario_saida = horario_saida;
        this.horario_chegada = horario_chegada; 
        this.valor_passagem = valor_passagem;
    }

    public Hora getHorario_saida() {
        return horario_saida;
    }

    public void setHorario_saida(Hora horario_saida) {
        this.horario_saida = horario_saida;
    }

    public Hora getHorario_chegada() {
        return horario_chegada;
    }

    public void setHorario_chegada(Hora horario_chegada) {
        this.horario_chegada = horario_chegada;
    }

    public int getValor_passagem() {
        return valor_passagem;
    }

    public void setValor_passagem(int valor_passagem) {
        this.valor_passagem = valor_passagem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getParada() {
        return parada;
    }

    public void setParada(String parada) {
        this.parada = parada;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public void cadastrarRota() {
        Scanner input = new Scanner(System.in);
        
        String origem;    
        String parada;    
        String destino;
        int hora_saida;          
        int minuto_saida;  
        int hora_chegada;  
        int minuto_chegada;  
        int valor_passagem;
                
        System.out.println("Origem da viagem: ");
        origem = input.nextLine();
        this.setOrigem(origem);
        
        System.out.println("Parada da viagem: ");
        parada = input.nextLine();
        this.setParada(parada);
        
        System.out.println("Destino da viagem: ");
        destino = input.nextLine();
        this.setDestino(destino);
        
        System.out.println("Hora da saida: ");
        hora_saida = input.nextInt();
        System.out.println("Minuto da saida: ");
        minuto_saida = input.nextInt();
        Hora hr_saida = new Hora(hora_saida, minuto_saida);
        this.setHorario_saida(hr_saida);

        System.out.println("Hora da chegada: ");
        hora_chegada = input.nextInt();
        System.out.println("Minuto da chegada: ");
        minuto_chegada = input.nextInt();
        Hora hr_chegada = new Hora(hora_chegada, minuto_chegada);
        this.setHorario_chegada(hr_chegada);
        
        System.out.println("Valor da passagem: ");
        valor_passagem = input.nextInt();
        this.setValor_passagem(valor_passagem);
        Random random = new Random();
        int ide;
        do{
            ide = random.nextInt(); 
        }while(ide > 0);
   
        this.setId(ide);
    }

    public void exibirRotas(int indice) {
            System.out.println("Indice: "+ indice + "\nOrigem da viagem: " + this.getOrigem() + 
                "\nParada da viagem: " + this.getParada() +
                "\nDestino da viagem: " + this.getDestino() +
                "\nHora da partida: " + this.getHorario_saida().getHora()+ ":" + this.getHorario_saida().getMinuto()+
                "\nHora da chegada: " + this.getHorario_chegada().getHora() + ":" + this.getHorario_chegada().getMinuto() +
                "\nValor da passagem: " + this.getValor_passagem()
            );
    }
    
    public void alterarRotas(){
	int op;
	Scanner input = new Scanner(System.in);
		
	do {
            System.out.println("\n1- Origem");
            System.out.println("2- Parada");
            System.out.println("3- Destino");
            System.out.println("4- Hora saida");
            System.out.println("5- Hora chegada");
            System.out.println("6- Valor passagem");
            System.out.println("Digite a opcao que deseja alterar: ");
            op = input.nextInt();
	} while(op < 1 || op > 6);
		
	if(op == 1) {
		String origem;
		System.out.println("Digite origem: ");
		origem = input.next();
		this.setOrigem(origem);
	}
		
	else if(op == 2) {
		String parada;
		System.out.println("Digite a parada: ");
		parada = input.next();
		this.setParada(parada);
	}
		
        else if (op == 3) {
		String destino;
                System.out.println("Digite o destino: ");
                destino = input.next();
                this.setDestino(destino);
	}
         else if (op == 4) {
		int hr, min;
                System.out.println("Digite as horas da saida");
                hr = input.nextInt();
                System.out.println("Digite os minutos da saida");
                min = input.nextInt();
                Hora hr_saida = new Hora(hr, min);
                this.setHorario_saida(hr_saida);
	}
        else if (op == 5) {
		int hr, min;
                System.out.println("Digite as horas da chegada");
                hr = input.nextInt();
                System.out.println("Digite os minutos da chegada");
                min = input.nextInt();
                Hora hr_chegada = new Hora(hr, min);
                this.setHorario_chegada(hr_chegada);
	}
        else if (op == 6) {
		int valor;
                System.out.println("Digite valor da passagem: ");
                valor = input.nextInt();
                this.setValor_passagem(valor);
	}
		
	System.out.println("Alteracao realizada");
    } 
}
