package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import org.postgresql.util.PSQLException;

import model.Contato;

public abstract class Menu {
	
	private final static String MENU = """
			--- Projeto Agenda ---
			
			1) Iniciar
			2) Encerrar
			
			""";
	private final static String AGENDA_MENU = """
			
			1) Criar Novo Contato
			2) Localizar Contato por ID
			3) Atualizar Contato por ID
			4) Apagar Contato por ID
			5) Listar Contatos
			6) Encerrar aplicação
			
			""";
	
	public static void exibirMenu() {
		Scanner scan = new Scanner(System.in);
		
			System.out.println(MENU);
			int opcao = Integer.parseInt(scan.nextLine());
			while(opcao != 2) {
				String url = "jdbc:postgresql://localhost:5432/Agenda";
				
				System.out.println("Entre com o nome de usuário:");
				String usuario = scan.nextLine();
				System.out.println("Entre com a senha:");
				String senha = scan.nextLine();
				
				try (Connection conexao = DriverManager.getConnection(url, usuario, senha)){
					System.out.println("Conexão bem-sucedida ao banco de dados!");
					Contato contato = new Contato();
					opcao = 0;
					
						while (opcao != 6) {
							
							System.out.println(AGENDA_MENU);
							opcao = scan.nextInt();
						    
							switch(opcao) {
						    case 1:
						    	contato.criarContato(conexao);
						    	break;
						    	
						    case 2:
						    	contato.lerContato(conexao);
						    	break;
						    	
						    case 3:
						    	contato.atualizarContato(conexao);
						    	break;
						    	
						    case 4:
						    	contato.apagarContato(conexao);
						    	break;
						    	
						    case 5:
						    	contato.listarContatos(conexao);
						    	break;
			
						    default:
						    	System.out.println("Agenda fechada.");
						    	opcao = 2;
						    	break;
						    	
						    }
						}
					
				} catch(PSQLException e) { 
					if(e.getMessage().contains("password authentication failed")) {
						
						System.out.println("Credenciais inválidas. \nVerifique nome de usuário e senha \ne tente novamente.");
					
					} else {
						
						System.out.println("Erro ao conectar ao banco de dados." + e.getMessage());
						e.printStackTrace();
					}
				}catch (SQLException e) {
					
					System.out.println("Erro ao conectar ao banco de dados:" + e.getMessage());
					e.printStackTrace();
				}
				
			}
		
	}

}
