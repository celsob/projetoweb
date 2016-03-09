package com.usjt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDao {

	public void incluir(VendedorTO to) {
		String sqlInsert = "INSERT INTO Vendedor(id, nome, fone) VALUES (?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getRegistro());
			stm.setString(2, to.getEndereco());
			stm.setString(3, to.getNome());
			stm.setString(4, to.getDatDasc());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(VendedorTO to) {
		String sqlUpdate = "UPDATE Vendedor SET nome=?, fone=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, to.getRegistro());
			stm.setString(2, to.getEndereco());
			stm.setString(3, to.getNome());
			stm.setString(4, to.getDatDasc());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(VendedorTO to) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getRegistro());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VendedorTO carregar(int id) {
		VendedorTO to = new VendedorTO();
		String sqlSelect = "SELECT nome, fone FROM cliente WHERE cliente.id = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					stm.setInt(1, to.getRegistro());
					stm.setString(2, to.getEndereco());
					stm.setString(3, to.getNome());
					stm.setString(4, to.getDatDasc());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;

	}
}
