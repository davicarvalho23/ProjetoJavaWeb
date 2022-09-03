package dao;

import static dao.Dao.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Cliente;

public class ClienteDao {
	public static Cliente getClienteById(int id) {
		Cliente cliente = null;
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from cliente where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setEstado(rs.getString("estado"));

			}
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return cliente;
	}

	public static int editarcliente(Cliente cliente) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("UPDATE cliente SET nome=?, email=?  WHERE id=?");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setInt(4, cliente.getId());
			status = ps.executeUpdate();
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return status;
	}

	public static List<Cliente> getClientes(int inicio, int total) {
		List<Cliente> list = new ArrayList<Cliente>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT * FROM cliente ORDER BY id LIMIT " + (inicio - 1) + " ," + total);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSenha(rs.getString("senha"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setData_de_criacao(rs.getTimestamp("data_de_criacao"));
				cliente.setData_da_ultima_modificacao(rs.getTimestamp("data_da_ultima_modificacao"));
				list.add(cliente);
			}
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return list;
	}

	public static List<Cliente> getRelatorio() {
		List<Cliente> list = new ArrayList<Cliente>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM cliente");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				list.add(cliente);
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
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT count(*) AS contagem FROM cliente");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				contagem = rs.getInt("contagem");
			}
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return contagem;
	}

	public static int[] getRelatorioclientes() {

		int[] valores = { 10, 20, 30, 40 };

		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("SELECT count(*) FROM cliente where estado = 'ativo'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				valores[0] = rs.getInt("Ativo");
			}

			ps = (PreparedStatement) con
					.prepareStatement("SELECT count(*) AS comum FROM cliente where estado = 'inativo'");
			rs = ps.executeQuery();
			while (rs.next()) {
				valores[1] = rs.getInt("Inativo");
			}

		} catch (Exception erro) {
			System.out.println(erro);
		}
		return valores;
	}

	public static int bloquearCliente(Cliente cliente) {
		int status = 0;
		String estadocliente = "";

		if (cliente.getEstado().equalsIgnoreCase("ativo")) {
			estadocliente = "inativo";
		} else if (cliente.getEstado().equalsIgnoreCase("inativo")) {
			estadocliente = "suspenso";
		} else if (cliente.getEstado().equalsIgnoreCase("suspenso")) {
			estadocliente = "banido";
		} else {
			estadocliente = "ativo";
		}
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE cliente SET estado=? WHERE id=?");
			ps.setString(1, estadocliente);
			ps.setInt(2, cliente.getId());
			status = ps.executeUpdate();
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return status;
	}

	public static int excluirCliente(Cliente cliente) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM cliente WHERE id=?");
			ps.setInt(1, cliente.getId());
			status = ps.executeUpdate();
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return status;
	}

	public static Cliente logar(String email, String senha) {
		Cliente cl = new Cliente();

		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("select * from cliente where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			// Verifica se a consulta retornou resultado
			if (rs.next()) {

				if (rs.getString("estado").equals("ativo")) {
					if (rs.getString("senha").equals(senha)) {
						cl.setId(rs.getInt("id"));
						cl.setNome(rs.getString("nome"));	
						cl.setEmail(rs.getString("email"));
						cl.setSenha(rs.getString("senha"));
						cl.setAcesso(rs.getString("acesso"));

					} else {
						// Senha errada
						cl = null;
					}
				} else {
					// Usuario Inativo
					cl = null;
				}

			} else {
				// E-mail não existe
				cl = null;
			}
		} catch (Exception erro) {
			System.out.println(erro);
		}
		return cl;
	}

	
}
