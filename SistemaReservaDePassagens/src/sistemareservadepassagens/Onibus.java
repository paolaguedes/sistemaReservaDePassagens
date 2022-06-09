
package sistemareservadepassagens;

import java.util.Scanner;

public class Onibus {
    private String modelo;
    private int ano_fabricacao;
    private String marca;
    private double quilometragem;
    private int [][] assento = new int[8][4];
    private Motorista motorista;

    public Onibus(String modelo, int ano_fabricacao, String marca, double quilometragem, int [][]assento) {
        this.modelo = modelo;
        this.ano_fabricacao = ano_fabricacao;
        this.marca = marca;
        this.quilometragem = quilometragem;
        this.assento = assento;
    }
    
    public Onibus() {}
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(int ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public int[][] getAssento() {
        return assento;
    }

    public void setAssento(int i, int j) {
        if((i >= 0 && i <= 7) && (j>=0 && j<=3) && (this.assento[i][j] == 0))
            this.assento[i][j] = 1;
        else if(this.assento[i][j] == 1)
            this.assento[i][j] = 0;
        else
            System.out.println("Coordenadas de assento invalidas!");
    } 
    
    public Motorista getMotorista() {
        return motorista;
    }
    
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
    
    public void cadastrarOnibus() {
        Scanner input = new Scanner(System.in);
        
        String modelo;
        int ano;
        String marca;
        double quilometragem;        
        
        System.out.println("Modelo do onibus: ");
        modelo = input.nextLine();
        this.setModelo(modelo);
        
        System.out.println("Ano da fabricacao: ");
        ano = input.nextInt();
        this.setAno_fabricacao(ano);
        
        System.out.println("Marca do onibus: ");
        marca = input.next();
        this.setMarca(marca);
        
        System.out.println("Quilometragem: ");
        quilometragem = input.nextDouble();
        this.setQuilometragem(quilometragem);      
    }
     
    public void exibirAssentos() {	
	int i,j;
	
        System.out.println("\n0 - Assento livre | 1 - Assento ocupado\n");
	System.out.println(" 0   1   2   3");
	for(i=0; i<8; i++) {
            System.out.print(i + " ");
            for(j=0; j<4; j++) {
		if(j == 2)
                    System.out.print(" ");
                    System.out.printf("[%d]", this.assento[i][j]);
            }
            System.out.printf("\n");
	} 	
    }
    
    public void exibirOnibus(int indice) {
        Scanner input = new Scanner(System.in);
	
	System.out.println("Indice: " + indice + " Modelo: " + this.getModelo() + " ano: " + this.getAno_fabricacao() );	
	}
    
    public void alterarOnibus() {
	int op;
	Scanner input = new Scanner(System.in);
		
	do {
		System.out.println("\n1- Modelo");
		System.out.println("\n2- Marca");
		System.out.println("\n3- Kilometragem");
		System.out.println("Digite a opcao que deseja alterar: ");
		op = input.nextInt();
	} while(op < 1 || op > 3);
		
	if(op == 1) {
		String modelo;
		System.out.println("Digite o modelo do onibus: ");
		modelo = input.next();
		this.setModelo(modelo);
	}
		
	else if(op == 2) {
		String marca;
		System.out.println("Digite a marca do onibus: ");
		marca = input.next();
		this.setMarca(marca);
	}
		
        else {
		double km;
		System.out.println("Digite a kilometragem: ");
                km = input.nextDouble();
                this.setQuilometragem(km);
	}
		
	System.out.println("Alteracao realizada");
    }
}

