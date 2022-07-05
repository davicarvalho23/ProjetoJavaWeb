package classes;

import java.sql.Timestamp;
  
public class Artista {
private int id; 
private String nome; 
private String nome_artistico;
private String email;
private String senha; 
private MyEnum estado;
private String biografia;
private Timestamp data_de_criacao;
private Timestamp data_da_ultima_modificacao;
private Timestamp data_da_ultima_autenticacao;


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

public Timestamp getData_de_criacao() {
	return data_de_criacao;
}
public void setData_de_criacao(Timestamp data_de_criacao) {
	this.data_de_criacao = data_de_criacao;
}
public Timestamp getData_da_ultima_modificacao() {
	return data_da_ultima_modificacao;
}
public void setData_da_ultima_modificacao(Timestamp data_da_ultima_modificacao) {
	this.data_da_ultima_modificacao = data_da_ultima_modificacao;
}
public Timestamp getData_da_ultima_autenticacao() {
	return data_da_ultima_autenticacao;
}
public void setData_da_ultima_autenticacao(Timestamp data_da_ultima_autenticacao) {
	this.data_da_ultima_autenticacao = data_da_ultima_autenticacao;
}

public enum MyEnum { ATIVO, INATIVO, SUSPENSO, BANIDO}
}
