package classes;



public class Artista {
private int id; 
private String nome; 
private String nome_artistico;
private String email;
private String senha; 
private MyEnum estado;
private String biografia;

enum MyEnum { ATIVO, INATIVO, SUSPENSO, BANIDO}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getNome_artistico() {
	return nome_artistico;
}
public void setNome_artistico(String nome_artistico) {
	this.nome_artistico = nome_artistico;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}

public String getBiografia() {
	return biografia;
}

public void setBiografia( String biografia) {
	this.biografia = biografia;
}
public MyEnum getEstado() {
	return estado;
}
public void setEstado(MyEnum estado) {
	this.estado = estado;
}


}
