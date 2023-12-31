package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
	
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		/*Criamos o connection padrão, em seguida o statement que será a logica em que queremos a informação e por ultimo o resultado
		 * para mostrar na tela*/
		
		try {
			 conn = DB.getConnection();
			 
			 st = conn.createStatement();
			 
			 rs = st.executeQuery("select * from department");
			 /*Criamos a consulta com o string que está dentro do metodo executeQuery*/
			 
			 while (rs.next()) {
				 System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
				 //E por fim criamos o next que irá percorrer até o final printando na tela o resultado
			 }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResult(rs);
			DB.closeStatement(st);
			DB.closeConnection();
			//Para que o programa não fique executando eternamente  o banco de dados, fechamos com finally, porém criamos um metodo de exception para cada
		}
	}
}
