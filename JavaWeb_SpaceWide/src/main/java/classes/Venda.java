package classes;

import java.sql.Timestamp;
import java.math.BigDecimal;


public class Venda {
private int id_venda;
private int id_artista;
private BigDecimal total;
private String estado;
private Timestamp data_de_criacao;
private Timestamp data_da_ultima_modificacao;




public int getId_venda() {
	return id_venda;
}
public void setId_venda(int id_venda) {
	this.id_venda = id_venda;
}
public int getId_artista() {
	return id_artista;
}
public void setId_artista(int id_artista) {
	this.id_artista = id_artista;
}
public BigDecimal getTotal() {
	return total;
}
public void setTotal(BigDecimal total) {
	this.total = total;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
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



	
}
