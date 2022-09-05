/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Obra_artistica;

import static dao.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Obra_ArtisticaDao {

	public static Obra_artistica getObra_artisticaById(int id) {
		Obra_artistica obra = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from obra_artistica where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				obra = new Obra_artistica();
				obra.setId(rs.getInt("id_obra_artistica"));
				obra.setId_artista(rs.getInt("id_artista"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setDescricao(rs.getString("descricao"));
				obra.setLocalizacao_da_imagem(rs.getString("localizacao_da_imagem"));

			}
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return obra;
	}

	public static List<Obra_artistica> getObra_artistica(int inicio, int total) {
		List<Obra_artistica> list = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT * FROM obra_artistica ORDER BY id LIMIT " + (inicio - 1) + " ," + total);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Obra_artistica obra = new Obra_artistica();
				obra.setId(rs.getInt("id"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setSubtitulo(rs.getString("subtitulo"));
				obra.setLocalizacao_da_imagem(rs.getString("localizacao_da_imagem"));
				obra.setEstado(rs.getString("estado"));
				obra.setData_de_criacao(rs.getTimestamp("data_de_criacao"));
				obra.setData_da_ultima_modificacao(rs.getTimestamp("data_da_ultima_modificacao"));
			
				list.add(obra);
			}
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return list;
	}

	public static List<Obra_artistica> getRelatorio() {
		List<Obra_artistica> list = new ArrayList<Obra_artistica>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM obra_artistica");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Obra_artistica obra = new Obra_artistica();
				obra.setId(rs.getInt("id_cliente"));
				obra.setTitulo(rs.getString("titulo"));
				list.add(obra);
			}
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return list;
	}

	public static int getContagem() {
		int contagem = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT count(*) AS contagem FROM obra_artistica");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				contagem = rs.getInt("contagem");
			}
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return contagem;
	}

	public static int[] getRelatorioObra() {

		int[] valores = { 10, 20, 30, 40 };

		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) FROM cliente ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				valores[0] = rs.getInt("ativo");
			}

			ps = (PreparedStatement) con.prepareStatement("SELECT count(*) FROM cliente where");
			rs = ps.executeQuery();
			while (rs.next()) {
				valores[1] = rs.getInt("inativo");
			}

		} catch (Exception erro) {
			System.out.println(erro);
		}
		return valores;
	}

	public static int bloquearObra(Obra_artistica obra) {
		int status = 0;
		String estadoobra = "";

		if (obra.getEstado().equalsIgnoreCase("ativo")) {
			estadoobra = "inativo";
		} else if (obra.getEstado().equalsIgnoreCase("inativo")) {
			estadoobra = "suspenso";
		} else if (obra.getEstado().equalsIgnoreCase("suspenso")) {
			estadoobra = "banido";
		} else {
			estadoobra = "ativo";
		}
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("UPDATE obra_artisitica SET estado=? WHERE id=?");
			ps.setString(1, estadoobra);
			ps.setInt(2, obra.getId());
			status = ps.executeUpdate();
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return status;
	}

	public static int excluirObra(Obra_artistica obra) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM obra_artistica WHERE id=?");
			ps.setInt(1, obra.getId());
			status = ps.executeUpdate();
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return status;
	}

}
