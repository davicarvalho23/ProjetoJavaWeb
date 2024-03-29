package classes;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Obra_artistica {
	private int id;
	private int id_artista;
	private String titulo;
	private String subtitulo;
	private String descricao;
	private String localizacao_da_imagem;
	private String estado;
	private Timestamp data_de_criacao;
	private Timestamp data_da_ultima_modificacao;


	SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy");

	public String getData_de_criacao() {
		return String.format("%1$TD %1$TT", data_de_criacao);
	}

	public void setData_de_criacao(Timestamp data_de_criacao) {
		this.data_de_criacao = data_de_criacao;
	}

	public String getData_da_ultima_modificacao() {
		return String.format("%1$TD %1$TT", data_da_ultima_modificacao);
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

	public int getId_artista() {
		return id_artista;
	}

	public void setId_artista(int id_artista) {
		this.id_artista = id_artista;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao_da_imagem() {
		return localizacao_da_imagem;
	}

	public void setLocalizacao_da_imagem(String localizacao_da_imagem) {
		this.localizacao_da_imagem = localizacao_da_imagem;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

}
