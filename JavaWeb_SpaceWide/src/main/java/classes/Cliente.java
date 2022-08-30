package classes;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Cliente {
private int id; 
private String nome;
private String email;
private String senha;
private String estado;
private String acesso;
private Timestamp data_de_criacao;
private Timestamp data_da_ultima_modificacao;

SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");


public String getData_de_criacao() {
	return String.format("%1$TD %1$TT",data_de_criacao);
}
public void setData_de_criacao(Timestamp data_de_criacao) {
	this.data_de_criacao = data_de_criacao;
}
public String getData_da_ultima_modificacao() {
	return String.format("%1$TD %1$TT",data_da_ultima_modificacao);
}
public void setData_da_ultima_modificacao(Timestamp data_da_ultima_modificacao) {
	this.data_da_ultima_modificacao = data_da_ultima_modificacao;
}
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
    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

}
