package classes;

  
public class Obra_artistica {
private int id;
private String id_artista;
private String titulo;
private String descricao;
private double valor; 
private String localizacao_da_imagem;
private String estado;



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public String getId_artista() {
	return id_artista;
}
public void setId_artista(String id_artista) {
	this.id_artista = id_artista;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}
public String getLocalizacao_da_imagem() {
	return localizacao_da_imagem;
}
public void setLocalizacao_da_imagem(String localizacao_da_imagem) {
	this.localizacao_da_imagem = localizacao_da_imagem;
}
	
	
	
	
}
