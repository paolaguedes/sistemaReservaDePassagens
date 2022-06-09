
package sistemareservadepassagens;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaReservaDePassagens {

        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Rotas> rotasLista = new ArrayList<>();
        ArrayList<Onibus> onibusLista = new ArrayList<>();
        ArrayList<Motorista> motoristaLista = new ArrayList<>();
        ArrayList<Passageiro> passageirosLista = new ArrayList<>();
        
        //---------------------------------------
        
        int op_2;
        do {
            System.out.println("Escolha o modo: "
                    + "\n 1- administrador "
                    + "\n 2- passageiro "
                    + "\n 0- sair ");
            op_2 = input.nextInt();

            if(op_2 == 1) {
                int op = 1;

                while(op != 0 ) {
                    System.out.println("Escolha uma opcao:"
                            + "\n 1- cadastrar motorista"
                            + "\n 2- alterar motorista"
                            + "\n 3- excluir motorista"
                            + "\n 4- cadastrar onibus"
                            + "\n 5- alterar onibus"
                            + "\n 6- excluir onibus"
                            + "\n 7- cadastrar rota"
                            + "\n 8- alterar rota"
                            + "\n 9- excluir rota"
                            + "\n 0- sair"
                    );
                    op = input.nextInt();

                    if(op == 1) {
                        Motorista motorista1 = new Motorista();
                        motorista1.cadastrarMotorista();
                        motoristaLista.add(motorista1);
                    }            
                    else if(op == 2) {
                        if(!motoristaLista.isEmpty()){
                            for(int i=0;i<motoristaLista.size();i++)
                                motoristaLista.get(i).exibirMotorista(i);

                            System.out.println("Indice do motorista a ser alterado");
                            int op_1 =  input.nextInt();

                            if(op_1 < motoristaLista.size() && op_1 >= 0)
                                motoristaLista.get(op_1).alterarMotorista();
                            else
                                System.out.println("Sem motoristas");
                        } else
                            System.out.println("Sem motoristas cadastrados");
                    }
                    else if(op == 3) {
                        if(!motoristaLista.isEmpty()) {
                            for(int i=0;i<motoristaLista.size();i++)
                                motoristaLista.get(i).exibirMotorista(i);

                            System.out.println("Indice do motorista a ser excluido");
                            int op_1 =  input.nextInt();

                            if(onibusLista.isEmpty()) {
                                if(op_1 < motoristaLista.size() && op_1 >= 0)
                                    motoristaLista.remove(op_1);
                                else
                                    System.out.println("Sem motoristas");
                            } else {
                                for(int i=0;i<onibusLista.size();i++) {
                                    if(onibusLista.get(i).getMotorista().getNome().equals(motoristaLista.get(op_1).getNome())) {
                                        System.out.println("Esse motorista ja pertencia a um onibus, por isso cadastre um novo em seu lugar.");
                                        
                                        Motorista motorista1 = new Motorista();    
                                        motorista1.cadastrarMotorista();
                                        motoristaLista.add(op_1, motorista1);
                                        
                                        onibusLista.get(i).setMotorista(motorista1);
                                    }
                                }
                            }
                        } else
                            System.out.println("Sem motoristas cadastrados");
                    }            
                    else if(op == 4) {
                        if(!motoristaLista.isEmpty()) {
                            Onibus onibus_1 = new Onibus();
                            onibus_1.cadastrarOnibus();
                            
                            System.out.println("Motorista disponiveis:\n");
                            
                            for(int i=0;i<motoristaLista.size();i++)
				System.out.println("\tMotorista indice[" + i + "] - Nome: " + motoristaLista.get(i).getNome());
			
                            System.out.println("\nIndice do motorista para o Onibus: ");
                            int i = input.nextInt(); 
                            
                            if(i < motoristaLista.size() && i >= 0) {
				onibus_1.setMotorista(motoristaLista.get(i));
				onibusLista.add(onibus_1);
								
				System.out.println("\nOnibus de modelo: "+ onibus_1.getModelo()+ " foi cadastrado com sucesso!");
                            } else
				System.out.println("Desculpe, nao ha motoristas cadastrados com o codigo inserido!");
                        } else
                            System.out.println("Cadastre primeiro algum motorista");
                    }
                    else if(op == 5) {
                        if(!onibusLista.isEmpty()) {
                            for(int i=0;i<onibusLista.size();i++)
                                onibusLista.get(i).exibirOnibus(i);

                            System.out.println("Indice do onibus a ser alterado");
                            int op_1 =  input.nextInt();

                            if(op_1 < onibusLista.size() && op_1 >= 0)
                                onibusLista.get(op_1).alterarOnibus();
                            else
                                System.out.println("Sem onibus");
                        }  else
                            System.out.println("Sem onibus cadastrados");
                    }            
                    else if(op == 6) {
                        if(!onibusLista.isEmpty()) {
                            for(int i=0;i<onibusLista.size();i++)
                                onibusLista.get(i).exibirOnibus(i);

                            System.out.println("Indice do onibus a ser excluido");
                            int op_1 =  input.nextInt();
                            
                            if(rotasLista.isEmpty()) {
                                if(op_1 < onibusLista.size() && op_1 >= 0)
                                    onibusLista.remove(op_1);
                                else
                                    System.out.println("Sem onibus");
                            } else {
                                for(int i=0;i<rotasLista.size();i++) {
                                    if(rotasLista.get(i).getOnibus().getModelo().equals(onibusLista.get(op_1).getModelo())) {
                                        System.out.println("Esse onibus ja pertencia a uma rota, por isso cadastre um novo em seu lugar.");
                                        
                                        Onibus onibus_1 = new Onibus();
                                        onibus_1.cadastrarOnibus();
                                        onibusLista.add(op_1, onibus_1);
                                        
                                        rotasLista.get(i).setOnibus(onibus_1);
                                    }
                                }
                            }
                        }  else
                            System.out.println("Sem onibus cadastrados");
                    }
                    else if(op == 7) {
                        if(!onibusLista.isEmpty()) {
                            Rotas rota_1 = new Rotas();
                            rota_1.cadastrarRota();

                            System.out.println("Onibus disponiveis:");
                            for(int i=0;i<onibusLista.size();i++)
                                System.out.println("\n\tOnibus indice[" + i + "] - Modelo: " + onibusLista.get(i).getModelo());

                            System.out.println("\nIndice do onibus para a rota: ");
                            int i = input.nextInt();				

                            if(i < onibusLista.size() && i >= 0) {
                                rota_1.setOnibus(onibusLista.get(i));
                                rotasLista.add(rota_1);

                                System.out.println("A rota para "+ rota_1.getDestino() +" foi cadastrada com sucesso!");
                            } else
                                System.out.println("Desculpe, nao ha onibus cadastrados com o codigo inserido!");
                        } else 
                            System.out.println("Cadastre primeiro um onibus");
                    }            
                    else if(op == 8) {
                        if(!rotasLista.isEmpty()) {
                            for(int i=0;i<rotasLista.size();i++)
                                rotasLista.get(i).exibirRotas(i);

                            System.out.println("Indice da rota a ser alterado");
                            int op_1 =  input.nextInt();

                            if(op_1 < rotasLista.size() && op_1 >= 0)
                                rotasLista.get(op_1).alterarRotas();
                            else
                                System.out.println("Sem rotas");
                        }  else
                            System.out.println("Sem rotas cadastradas");
                    }
                    else if(op == 9) {
                        if(!rotasLista.isEmpty()) {
                            for(int i=0;i<rotasLista.size();i++)
                                rotasLista.get(i).exibirRotas(i);

                            System.out.println("Indice da rota a ser excluido");
                            int op_1 =  input.nextInt();

                            if(op_1 < rotasLista.size() && op_1 >= 0)
                                rotasLista.remove(op_1);
                            else
                                System.out.println("Sem Rotas");
                        }  else
                            System.out.println("Sem rotas cadastradas");
                    }
                }
            }
            else if(op_2 == 2) {

                int op_3;
                do {
                    System.out.println("Menu: "
                            + "\n 1- criar conta "
                            + "\n 2- alterar dados "
                            + "\n 3- excluir conta "
                            + "\n 4- reservar assento "
                            + "\n 0- sair "
                    );
                    op_3 = input.nextInt();

                    if(op_3 == 1 ) {
                        if(!rotasLista.isEmpty()) {
                            Passageiro passageiro1 = new Passageiro();
                            passageiro1.cadastrarPassageiro();
                            passageirosLista.add(passageiro1);
                        } else
                            System.out.println("Sem rotas disponiveis no momento....");
                    }
                    else if(op_3 == 2) {
                        if(!passageirosLista.isEmpty()) {
                            for(int i=0;i<passageirosLista.size();i++)
                                passageirosLista.get(i).exibirPassageito(i);

                            System.out.println("Indice do passageito a ser alterado");
                            int op_1 =  input.nextInt();

                            if(op_1 < passageirosLista.size() && op_1 >= 0)
                                passageirosLista.get(op_1).alterarPassageiro();
                            else
                                System.out.println("Sem Passageiros");
                        } else 
                            System.out.println("Sem passageiros cadastrados");
                    }
                    else if(op_3 == 3) {
                        if(!passageirosLista.isEmpty()) {
                            for(int i=0;i<passageirosLista.size();i++)
                                passageirosLista.get(i).exibirPassageito(i);

                            System.out.println("Indice do passageiro a ser excluido");
                            int op_1 =  input.nextInt();

                            if(op_1 < passageirosLista.size() && op_1 >= 0){
                               int linha = passageirosLista.get(op_1).getLinha();
                               int coluna = passageirosLista.get(op_1).getColuna();

                               for(int i =0; i < rotasLista.size(); i++){
                                   if( passageirosLista.get(op_1).getId_passagem() == rotasLista.get(i).getId()){
                                       rotasLista.get(i).getOnibus().setAssento(linha, coluna);
                                   }
                               }
                               passageirosLista.remove(op_1);
                            }
                            else
                                System.out.println("Sem Passageiros");
                        } else 
                            System.out.println("Sem passageiros cadastrados");
                    }
                    else if(op_3 == 4) {
                        System.out.println("Digite seu rg");
                        int rg = input.nextInt();
                        
                        for(int i=0; i < passageirosLista.size(); i++) {
                            if(passageirosLista.get(i).getRg() == rg && passageirosLista.get(i).getId_passagem() == 0) {
                                if(!rotasLista.isEmpty()){
                                    for(int j=0;j<rotasLista.size();j++) {
                                        rotasLista.get(j).exibirRotas(j);
                                        System.out.println("Modelo do onibus: "+ rotasLista.get(j).getOnibus().getModelo());                                    
                                        System.out.println("Nome do motorista: "+ rotasLista.get(j).getOnibus().getMotorista().getNome());
                                    }

                                    System.out.println("Escolha o indice da rota: ");
                                    int indice = input.nextInt();

                                    for(int k=0;k<rotasLista.size();k++)
                                        onibusLista.get(k).exibirAssentos();

                                    System.out.println("Digite as coordenadas do assento (ex.: 0 1)");
                                    System.out.println("Linha do assento: ");
                                    int linha =  input.nextInt();

                                    System.out.println("Coluna do assento: ");
                                    int coluna =  input.nextInt();

                                    if(rotasLista.get(indice).getOnibus().getAssento()[linha][coluna] == 1)
                                        System.out.println("Assento ja reservado");
                                    else {
                                        rotasLista.get(indice).getOnibus().setAssento(linha, coluna);

                                        System.out.println("Reserva do assento:"+ linha + coluna +" realizada");
                                        passageirosLista.get(i).setId_passagem(rotasLista.get(indice).getId());
                                        passageirosLista.get(i).setLinha(linha);
                                        passageirosLista.get(i).setColuna(coluna);
                                    }
                                } else 
                                    System.out.println("Sem passageiros cadastrados");
                            } 
                        }    
                    }
                } while(op_3 != 0);
            }
        } while(op_2 != 0);
    }
}