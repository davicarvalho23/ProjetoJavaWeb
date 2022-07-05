package classes;
import java.sql.Timestamp;
import java.math.BigDecimal;


public class Contribuicao{
	private int id_contribuicao;
	public int id_artista;
	public int id_cliente;
	private byte mensalidade;
	private BigDecimal valor;
	private Timestamp data_inical;
	private Timestamp data_final;
	private Timestamp data_de_criacao;
	private Timestamp data_de_ultima_modificacao;
	
	public int getId_contribuicao() {
		return id_contribuicao;
	}
	public void setId_contribuicao(int id_contribuicao) {
		this.id_contribuicao = id_contribuicao;
	}
	public int getId_artista() {
		return id_artista;
	}
	public void setId_artista(int id_artista) {
		this.id_artista = id_artista;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public byte getMensalidade() {
		return mensalidade;
	}
	public void setMensalidade(byte mensalidade) {
		this.mensalidade = mensalidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Timestamp getData_inical() {
		return data_inical;
	}
	public void setData_inical(Timestamp data_inical) {
		this.data_inical = data_inical;
	}
	public Timestamp getData_final() {
		return data_final;
	}
	public void setData_final(Timestamp data_final) {
		this.data_final = data_final;
	}
	public Timestamp getData_de_criacao() {
		return data_de_criacao;
	}
	public void setData_de_criacao(Timestamp data_de_criacao) {
		this.data_de_criacao = data_de_criacao;
	}
	public Timestamp getData_de_ultima_modificacao() {
		return data_de_ultima_modificacao;
	}
	public void setData_de_ultima_modificacao(Timestamp data_de_ultima_modificacao) {
		this.data_de_ultima_modificacao = data_de_ultima_modificacao;
	}
	
	
	
	
}
