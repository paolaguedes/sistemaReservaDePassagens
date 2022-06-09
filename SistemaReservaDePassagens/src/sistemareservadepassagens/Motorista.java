
package sistemareservadepassagens;

import java.util.Scanner;

public class Motorista {
    private int cnh;
    private Data dt_admissao;
    private String nome;
    
    public Motorista(int cnh, Data dt_admissao, String nome) {
        this.cnh = cnh;
        this.dt_admissao = dt_admissao;
        this.nome = nome;
    }
    
    public Motorista(){}
    
    public int getCnh() {
        return cnh;
    }

    public void setCnh(int cnh) {
        this.cnh = cnh;
    }

    public Data getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(Data dt_admissao) {
        this.dt_admissao = dt_admissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void cadastrarMotorista() {
        
        Scanner input = new Scanner(System.in);
        String nome;
        int dia_adm;
        int mes_adm;
        int ano_adm;
        int cnh;
               
        System.out.println("Nome motorista: ");
        nome = input.nextLine();
        this.setNome(nome);
        
        System.out.println("Dia da admissao: ");
        dia_adm = input.nextInt();
        System.out.println("Mes da admissao: ");
        mes_adm = input.nextInt();
        System.out.println("Ano da admissao: ");
        ano_adm = input.nextInt();
        
        Data dta_admissao = new Data(dia_adm, mes_adm, ano_adm);
        this.setDt_admissao(dta_admissao);
        
        System.out.println("Numero CNH: ");
        cnh = input.nextInt();
        this.setCnh(cnh);        
    }
  
    public void exibirMotorista(int indice) {
        Scanner input = new Scanner(System.in);
	
	System.out.println("Indice: " + indice + " Motorista: " + this.getNome() + " Cnh: " + this.getCnh() );	
    }
    
    public void alterarMotorista(){
	int op;
	Scanner input = new Scanner(System.in);
		
	do {
		System.out.println("\n1- Nome");
		System.out.println("2- CHN");
		System.out.println("3- Data de admissão");
		System.out.println("Digite a opcao que deseja alterar: ");
		op = input.nextInt();
	} while(op < 1 || op > 3);
		
	if(op == 1) {
		String nome;
		System.out.println("Digite o nome do motorista: ");
		nome = input.next();
		this.setNome(nome);
	}
		
	else if(op == 2) {
		int cnh;
		System.out.println("Digite a CNH do passageiro: ");
		cnh = input.nextInt();
		this.setCnh(cnh);
	}
		
        else {
		int dia, mes, ano;
		System.out.println("Dia: ");
		dia = input.nextInt();
                System.out.println("Mes: ");
		mes = input.nextInt();
                System.out.println("ano: ");
		ano = input.nextInt();
		Data dta_admissao = new Data(dia, mes, ano);
                this.setDt_admissao(dta_admissao);
	}
		
	System.out.println("Alteracao realizada");
    }
}