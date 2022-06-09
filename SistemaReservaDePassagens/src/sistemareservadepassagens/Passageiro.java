
package sistemareservadepassagens;

import java.util.Scanner;

public class Passageiro {

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    private int rg;
    private String nome;
    private Data dt_nasc;
    private String endereco;
    private int id_passagem = 0;
    private int linha;
    private int coluna;

    public int getId_passagem() {
        return id_passagem;
    }

    public void setId_passagem(int id_passagem) {
        this.id_passagem = id_passagem;
    }
    
    public Passageiro(String nome, Data dt_nasc, String endereco, int rg) {
        this.rg = rg;
        this.dt_nasc = dt_nasc;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Passageiro() {}
    
    public Data getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Data dt_nasc) {
        this.dt_nasc = dt_nasc;
    }
   
    public int getRg() {
        return this.rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void cadastrarPassageiro() {
        Scanner input = new Scanner(System.in);
        
        String nome;
        int dia_nasc;
        int mes_nasc;
        int ano_nasc;
        String endereco;
        int rg;
                
        System.out.println("Nome passageiro: ");
        nome = input.nextLine();
        this.setNome(nome);
        
        System.out.println("Dia da nascimento: ");
        dia_nasc = input.nextInt();
        System.out.println("Mes da nascimento: ");
        mes_nasc = input.nextInt();
        System.out.println("Ano da nascimento: ");
        ano_nasc = input.nextInt();
        
        Data dta_nasc = new Data(dia_nasc, mes_nasc, ano_nasc);
        this.setDt_nasc(dta_nasc);
        
        System.out.println("Endereco: ");
        endereco = input.next();
        this.setEndereco(endereco);
        
        System.out.println("Rg: ");
        rg = input.nextInt();
        this.setRg(rg);
    }
     
    public void exibirPassageito(int indice) {
        Scanner input = new Scanner(System.in);
	
	System.out.println("Indice: " + indice + " Passageiro: " + this.getNome() + " Rg: " + this.getRg());	
    }
    
    public void alterarPassageiro() {
	int op;
	Scanner input = new Scanner(System.in);
		
	do {
		System.out.println("\n1- Nome");
		System.out.println("2- Rg");
		System.out.println("3- Endereco");
                System.out.println("4- Data de nascimento");
		System.out.println("Digite a opcao que deseja alterar: ");
		op = input.nextInt();
	} while(op < 1 || op > 4);
		
	if(op == 1) {
		String nome;
		System.out.println("Digite o nome do passageiro: ");
		nome = input.next();
		this.setNome(nome);
	}
		
	else if(op == 2) {
		int rg;
		System.out.println("Digite o Rg: ");
		rg = input.nextInt();
		this.setRg(rg);
	}
		
        else if(op == 3) {
		String endereco;
		System.out.println("Digite o endereço: ");
                endereco = input.next();
                this.setEndereco(endereco);
	}
        
        else if(op == 4) {
		int dia, mes, ano;
		System.out.println("Dia: ");
		dia = input.nextInt();
                System.out.println("Mes: ");
		mes = input.nextInt();
                System.out.println("ano: ");
		ano = input.nextInt();
		Data dta_nasc = new Data(dia, mes, ano);
                this.setDt_nasc(dta_nasc);
	}
		
	System.out.println("Alteracao realizada");
    }
}

