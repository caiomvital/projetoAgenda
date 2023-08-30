package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Contato {

	//private int id;
	private String nome;
	private String telefone;

	public void criarContato(Connection conexao) throws SQLException {
		String sql = "INSERT INTO contatos (nome, telefone) VALUES (?, ?)";
		Scanner scan = new Scanner(System.in);
		
			try (PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				System.out.println("Entre com o nome do contato:");
				nome = scan.nextLine();
				System.out.println("Entre com o telefone do contato:");
				telefone = scan.nextLine();
				ps.setString(1, nome);
				ps.setString(2, telefone);
				ps.executeUpdate();

				try (ResultSet chavesGeradas = ps.getGeneratedKeys()) {
					if(chavesGeradas.next()) {

						int idInserido = chavesGeradas.getInt(1);
						System.out.println("Contato inserido com sucesso!");
						System.out.println("ID: " + idInserido);
						System.out.println("Nome: " + nome);
						System.out.println("Telefone: " + telefone.substring(0, telefone.length() - 4) + "-" + telefone.substring(telefone.length() - 4));

					}
				}
			} catch (SQLException e) {
				System.out.println("Erro na criação do contato!" + e.getMessage());
				e.printStackTrace();
			}
		 

	}

	public void lerContato(Connection conexao) throws SQLException {
		String sql = "SELECT * FROM contatos WHERE id = ?";
		Scanner scan = new Scanner(System.in);
		
			try(PreparedStatement ps = conexao.prepareStatement(sql)) {
				System.out.println("Entre com o ID que deseja buscar");
				int id = Integer.parseInt(scan.nextLine());
				ps.setInt(1, id);

				try (ResultSet resultSet = ps.executeQuery()) {

					if(resultSet.next()) {
						int contatoId = resultSet.getInt("id");
						String nome = resultSet.getString("nome");
						String telefone = resultSet.getString("telefone");

						System.out.println("ID: " + contatoId);
						System.out.println("Nome: " + nome);
						System.out.println("Telefone: " + telefone.substring(0, telefone.length() - 4) + "-" + telefone.substring(telefone.length() - 4));
					} else {
						System.out.println("Nenhum contato encontrado com o ID informado.");
					}
				} catch (SQLException e) {
					System.out.println("Erro ao executar a consulta: " + e.getMessage());
					e.printStackTrace();
				}

			} catch (SQLException e) {
				System.out.println("Problemas com a busca. " + e.getMessage());
				e.printStackTrace();
			}
		


	}

	public void atualizarContato(Connection conexao) throws SQLException {
		String sql = "UPDATE contatos SET nome = ?, telefone = ? WHERE id = ?";
		Scanner scan = new Scanner(System.in);

		
			try(PreparedStatement ps = conexao.prepareStatement(sql)) {
				System.out.println("Informe o ID do contato que deseja atualizar");
				int id = Integer.parseInt(scan.nextLine());
				System.out.println("Informe novo nome:");
				String novoNome = scan.nextLine();
				ps.setString(1, novoNome);
				System.out.println("Informe novo telefone:");
				String novoTelefone = scan.nextLine();
				ps.setString(2, novoTelefone);

				ps.setInt(3, id);

				ps.executeUpdate();

				System.out.println("Contato atualizado com sucesso!");

			} catch (SQLException e) {
				System.out.println("Problemas ao atualizar contato." + e.getMessage());
				e.printStackTrace();
			}
		
	}

	public void apagarContato(Connection conexao) throws SQLException {
		String sql = "DELETE FROM contatos WHERE id = ?";
		Scanner scan = new Scanner(System.in);
		
			try (PreparedStatement ps = conexao.prepareStatement(sql)) {
				System.out.println("Informe o ID do contato que deseja apagar:");
				int id = Integer.parseInt(scan.nextLine());

				ps.setInt(1, id);
				ps.executeUpdate();

				System.out.println("Contato apagado com sucesso!");

			} catch(SQLException e) {
				System.out.println("Problemas ao apagar contato. " + e.getMessage() );
				e.printStackTrace();
			}
		
	}
	
	public void listarContatos(Connection conexao) throws SQLException {
		String sql = "SELECT * FROM contatos ORDER BY id";
		
		try(PreparedStatement ps = conexao.prepareStatement(sql)) {
			try(ResultSet resultSet = ps.executeQuery()) {
				while(resultSet.next()) {
					int id = resultSet.getInt("id");
					String nome = resultSet.getString("nome");
					String telefone = resultSet.getString("telefone");
					
					System.out.println("ID: " + id);
					System.out.println("Nome: " + nome);
					System.out.println("Telefone: " + telefone.substring(0, telefone.length() - 4) + "-" + telefone.substring(telefone.length() - 4));
				} 
			} catch (SQLException e) {
				System.out.println("Erro ao listar contatos. " + e.getMessage());
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar consulta. " + e.getMessage());
			e.printStackTrace();
		}
	}

}
