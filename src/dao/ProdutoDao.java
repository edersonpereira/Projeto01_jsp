package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



import bean.Produto;
import conexao.Conexao;

public class ProdutoDao {
	
	//Cadastro
	public static boolean cadastrar(String produto, double valor) {
		
		//SQL
		String sql = "INSERT INTO produtos (nomeProduto, valorProduto) VALUES (?, ?)";
		
		//Validar
		boolean valida = false;
		
		//Conex�o
		Conexao.obterConexao();
		
		//Tentativa
		try {
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setString(1, produto);
			pstmt.setDouble(2, valor);
			pstmt.execute();
			pstmt.close();
			
			valida = true;
		}catch(Exception erro) {
			System.out.println("Falha ao cadastrar o produto "+erro.getMessage());
		}finally {
			Conexao.finalizarConexao();
		}
		
		//Retorno
		return valida;
	}

	//Sele��o
	public static String selecionar() {
		
		//Estrutura
		String estrutura = "";
		//SQL
		String sql = "SELECT * FROM produtos";
		//Conex�o
		Conexao.obterConexao();
		//Tentativa
		try {
			Statement stmt = Conexao.conexao.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
		estrutura += "<tr>";
			estrutura += "<td>"+rs.getInt(1)+"</td>";
			estrutura += "<td>"+rs.getString(2)+"</td>";
			estrutura += "<td>"+rs.getDouble(3)+"</td>";
			estrutura += "<td><a href='produtos.jsp?idProduto="+rs.getInt(1)+"'class='btn btn-warning'>Alterar</a></td>";
			estrutura += "<td><a href='../requisicoes/excluirProduto.jsp?idProduto="+rs.getInt(1)+"' class=\"btn btn-danger\">Excluir</a></td>";
		estrutura += "</tr>";// possivel utilizar \" dentro de ""
		}
		}catch(Exception erro) {
			System.out.println("Falha ao listar os produtos "+erro.getMessage());
		}finally {
			Conexao.finalizarConexao();
		}
		//Retorno
		return estrutura;
		
	}
	
	//Exclus�o
	public static boolean excluir(int idProduto) {
		//SQL
		String sql = "DELETE FROM produtos WHERE idProduto = ?";
		//Conex�o
		Conexao.obterConexao();
		//Valida
		boolean valida = false;
		//Tentativa
		try {
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
		pstmt.setInt(1, idProduto);
		pstmt.execute();
		pstmt.close();
		valida = true;
		}catch(Exception erro) {
			System.out.println("Falha ao excluir "+erro.getMessage());
		}finally {
			Conexao.finalizarConexao();
		}
		//Retonro
		return valida;
	}
	
	//Obter dados de um produto espec�fico
	public static Produto selecionarProduto(int idProduto){
		
	//Objeto da classe Produto(Bean)
	Produto prod = new Produto();
	
	//SQL
	String sql = "SELECT * FROM produtos WHERE idProduto = ?";
	
	//Conexao
	Conexao.obterConexao();
	
	//Tentativa
	try {
		PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
		pstmt.setInt(1, idProduto);
		
		ResultSet rs = pstmt.executeQuery();
		rs.last();
		
		prod.setIdProduto(rs.getInt(1));
		prod.setNomeProduto(rs.getString(2));
		prod.setValorProduto(rs.getDouble(3));
		
		pstmt.close();
		rs.close();
		
	}catch(Exception erro) {
		System.out.println("Falha ao obter o produto "+erro.getMessage());
	}finally {
		Conexao.finalizarConexao();
	}
	//Retorno
	return prod;
	}
	
	//Alterar
	public static boolean alterar(int idProduto, String nomeProduto, double valorProduto) {
		
		//Valida
		boolean valida = false;
		
		//SQL
		String sql = "UPDATE produtos SET nomeProduto=?, valorProduto=? WHERE idProduto=?";
		
		//Conexao
		Conexao.obterConexao();
		
		//Tentativa
		try {
			PreparedStatement pstmt = Conexao.conexao.prepareStatement(sql);
			pstmt.setString(1, nomeProduto);
			pstmt.setDouble(2, valorProduto);
			pstmt.setInt(3, idProduto);
			pstmt.execute();
			pstmt.close();
			
			valida  = true;
		}catch(Exception erro) {
			System.out.println("Falha ao alterar o produto "+erro.getMessage());
		}finally {
			Conexao.finalizarConexao();
		}
		
		//Retorno
		return valida;
	}
}