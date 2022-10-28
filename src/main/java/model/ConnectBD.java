package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ConnectBD {
	
	String URL= "jdbc:mysql://localhost:3306/clubsesi";
	String login= "root";
	String password="";

	public ConnectBD() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Club> AllClubs() throws SQLException {
		Connection cnx = (Connection) DriverManager.getConnection(URL, login, password);
		ArrayList<Club> list = new ArrayList<Club>();
		Statement stm = (Statement) cnx.createStatement();
		String SQL = "SELECT *FROM CLUB";
		ResultSet rs = stm.executeQuery(SQL);
		while (rs.next()) {
			list.add(new Club(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));
		}
		
		return list;
	}
	
	public boolean addAbonne(Abonne a) throws SQLException {
		boolean result = false;
		Connection cnx = (Connection) DriverManager.getConnection(URL, login, password);
		String SQL = "INSERT INTO abonnement ( nomAbonne, prenomAbonne, dateAbonnement) VALUES(?, ?, ?)";
		PreparedStatement stm = (PreparedStatement) cnx.prepareCall(SQL);
		stm.setString(1, a.getNomAbonne());
		stm.setString(2, a.getPrenomAbonne());
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern); 
		String date = simpleDateFormat.format(new Date());
		stm.setString(3, date);
		int rows = stm.executeUpdate();
		if (rows>0) {
			result = true;
		}
		stm.close();
		cnx.close();
		
		return result;
		
	}
	
	public Abonne FindAbonne(int idClub) throws SQLException {
		Abonne a = null;
		Connection cnx = (Connection) DriverManager.getConnection(URL, login, password);
		Statement stm = (Statement) cnx.createStatement();
		String SQL = "SELECT * FROM abonnement WHERE idClub="+idClub;
		ResultSet rs = stm.executeQuery(SQL);
		while (rs.next()) {
			a = new Abonne(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		return a;
	}
	
	public boolean deleteAbonne(int idClub) throws SQLException {
		boolean result = false;
		Connection cnx = (Connection) DriverManager.getConnection(URL, login, password);
		PreparedStatement stm = (PreparedStatement)cnx.prepareStatement("DELETE FROM Abonne WHERE idClub=?");
		stm.setInt(1, idClub);
		int rows = stm.executeUpdate();
		if (rows > 0) {
			result = true;
		}
		stm.close();
		cnx.close();
		return result;
	}

}
