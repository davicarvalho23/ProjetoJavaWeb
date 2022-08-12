package classes;

import java.util.Calendar;



public class Administrador {
	private int id; 
	private String nome = ""; 
	private String email = "";
	private String senha = "";
	private String estado = "";
	private String codigo_validador = "";
	private Calendar data_de_criacao; 
	private Calendar data_da_ultima_modificacao;
	private Calendar data_da_ultima_autenticacao;
	
	
	
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCodigo_validador() {
		return codigo_validador;
	}
	public void setCodigo_validador(String codigo_validador) {
		this.codigo_validador = codigo_validador;
	}
	public Calendar getData_de_criacao() {
		return data_de_criacao;
	}
	public void setData_de_criacao(Calendar data_de_criacao) {
		this.data_de_criacao = data_de_criacao;
	}
	public Calendar getData_da_ultima_modificacao() {
		return data_da_ultima_modificacao;
	}
	public void setData_da_ultima_modificacao(Calendar data_da_ultima_modificacao) {
		this.data_da_ultima_modificacao = data_da_ultima_modificacao;
	}
	public Calendar getData_da_ultima_autenticacao() {
		return data_da_ultima_autenticacao;
	}
	public void setData_da_ultima_autenticacao(Calendar data_da_ultima_autenticacao) {
		this.data_da_ultima_autenticacao = data_da_ultima_autenticacao;
	}
	
	
	


}
