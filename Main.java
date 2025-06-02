package automovel;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Automovel_manegment maneger = new Automovel_manegment();
		Scanner sc = new Scanner(System.in);
		String arquivo = "dados.csv";
		
		try {
			maneger.carregarDeArquivo(arquivo);
		}catch(IOException e) {
			System.out.println("Arquivo não encontrado");
		}
		
		int op;
		do {
			System.out.println("\nMenu");
			System.out.println("1 - incluir");
			System.out.println("2 - remover");
			System.out.println("3 - alterar");
			System.out.println("4 - consultar");
			System.out.println("5 - lista");
			System.out.println("6 - salvar e sair");
			op = Integer.parseInt(sc.nextLine());
			
			switch(op) {
			case 1 -> {
				System.out.print("Placa: ");
				String placa = sc.nextLine();
				if(maneger.buscarPorPlaca(placa) != null) {
					System.out.println("Placa ja existe");
					break;
				}
				System.out.print("Modelo: ");
				String modelo = sc.nextLine();
				System.out.print("Marca: ");
				String marca= sc.nextLine();
				System.out.print("Ano: ");
				int ano = Integer.parseInt(sc.nextLine());
				System.out.println("Valor");
				double valor = Double.parseDouble(sc.nextLine());
				
				Automovel a = new Automovel(placa, modelo, marca, ano, valor);
				maneger.inserir(a);
				System.out.println("Inserido com sucesso");
			}
			
			case 2 ->{
				System.out.println("Placa: ");
				String placa = sc.nextLine();
				if(maneger.remover(placa))
					System.out.println("Removido");
				else
					System.out.println("Não encontrado");
			}
			
			case 3 -> {
				System.out.println("Placa: ");
				String placa = sc.nextLine();
				System.out.println("Novo modelo: ");
				String modelo = sc.nextLine();
				System.out.println("Nova marca:");
				String marca = sc.nextLine();
				System.out.println("Novo ano: ");
				int ano = Integer.parseInt(sc.nextLine());
				System.out.println("Novo valor: ");
				double valor = Double.parseDouble(sc.nextLine());
				
				Automovel novo =  new Automovel( placa, modelo, marca, ano, valor);
				maneger.alterar(placa, novo);
				System.out.println("Alterado com sucesso");
				}
			
			case 4 -> {
				System.out.println("Placa: ");
				String placa = sc.nextLine();
				Automovel a = maneger.buscarPorPlaca(placa);
				if(a != null) {
					System.out.println(a);
				}else {
					System.out.println("Não encontrado");
				}
			}
			
			case 5 -> {
				System.out.println("Ordenar por placa/modelo/marca): ");
				String criterio = sc.nextLine();
				for(Automovel a : maneger.listaOrdenado(criterio)) {
					System.out.println(a);
				}
			}
			
			case 6-> {
				try {
					maneger.salvarEmArquivo(arquivo);
					System.out.println("Dados salvos");
				}catch (IOException e){
					System.out.println("Error no salvamento");
				}
			}
			
			default -> System.out.println("ERROR 404; opção não encontrada!");
			}
		}while(op != 6);
		
		sc.close();
	}
}
