package classes;
/**
 * 
 * `id_obra_artistica` int(11) NOT NULL,
  `id_artista` int(11) NOT NULL,
  `titulo` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `subtitulo` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `descricao` varchar(275) COLLATE utf8_unicode_ci NOT NULL,
  `localizacao_da_imagem` varchar(125) COLLATE utf8_unicode_ci NOT NULL,
  `valor` decimal(6,2) NOT NULL,
  `id_promocao` int(11) NOT NULL,
 *
 */

public class obra_artistica {
private int id;
private String titulo;
private String subtitulo;
private String id_artista;
private String descricao;
private double valor; 
public String localizacao_da_imagem;



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
public String getSubtitulo() {
	return subtitulo;
}
public void setSubtitulo(String subtitulo) {
	this.subtitulo = subtitulo;
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
