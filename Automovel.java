package automovel;

public class Automovel {
	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	private double valor;
	
	public Automovel(String placa, String modelo, String marca, int ano, double valor) {
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.valor = valor;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo= modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca= marca;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "Placa: " + placa + ", Modelo: " + modelo + ", Marca: " + marca + ", Ano: " + ano + ", Valor: " + valor;
	}
	
	public String toCSV() {
		return placa + "," + modelo + "," + marca + "," + ano + "," + valor;
	}
}
