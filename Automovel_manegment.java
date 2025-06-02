package automovel;

import java.io.*;
import java.util.*;

public class Automovel_manegment {

	private ArrayList<Automovel> lista = new ArrayList<>();

	public void carregarDeArquivo(String nomeArquivo) throws IOException{
		File file = new File(nomeArquivo);
		if(!file.exists()) return;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String linha;
		while((linha = reader.readLine()) != null) {
			String[] dados = linha.split(",");
			if(dados.length == 5){
				String placa = dados[0];
				String modelo = dados[1];
				String marca = dados[2];
				int ano = Integer.parseInt(dados[3]);
				double valor = Double.parseDouble(dados[4]);
				lista.add(new Automovel(placa,modelo,marca,ano,valor));
			}
		}
		reader.close();
	}
	
	public void salvarEmArquivo(String nomeArquivo) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo));
		for(Automovel a : lista) {
			writer.write(a.toCSV());
			writer.newLine();
		}
		writer.close();
	}
	
	public boolean inserir(Automovel a) {
		if(buscarPorPlaca(a.getPlaca()) == null) {
			lista.add(a);
			return true;
		}
		return false;
	}
	
	public boolean remover(String placa) {
		Automovel a = buscarPorPlaca(placa);
		if(a != null) {
			lista.remove(a);
			return true;
		}
		return false;
	}
	
	public boolean alterar(String placa, Automovel novosDados) {
		Automovel a = buscarPorPlaca(placa);
		if(a != null) {
			a.setModelo(novosDados.getModelo());
			a.setMarca(novosDados.getMarca());
			a.setAno(novosDados.getAno());
			a.setValor(novosDados.getValor());
			return true;
		}
		return false;
	}
	
	public Automovel buscarPorPlaca(String placa) {
		for(Automovel a : lista) {
			if(a.getPlaca().equalsIgnoreCase(placa));
			return a;
		}
		return null;
	}

	
	public List<Automovel> listaOrdenado(String criterio){
		List<Automovel> copia = new ArrayList<>(lista);
		switch(criterio.toLowerCase()) {
		case "placa":
			copia.sort(Comparator.comparing(Automovel :: getPlaca));
			break;
		case "modelo":
			copia.sort(Comparator.comparing(Automovel :: getModelo));
			break;
		case "marca":
			copia.sort(Comparator.comparing(Automovel :: getMarca));
			break;
		default:
			System.out.println("ERROR 404 criterio não encontrado: ordenando por placa");
			copia.sort(Comparator.comparing(Automovel :: getPlaca));
		}
		return copia;
	}
}
