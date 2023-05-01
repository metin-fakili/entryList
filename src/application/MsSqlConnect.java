package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MsSqlConnect {
	private static String dbHost = "DESKTOP-QHTNKJR\\SQLSERVER";
	private static String dbPort = "1433";
	private static String dbName = "chess";
	private static String dbUser = "user";
	private static String dbPass = "password";

	Connection c = null;

	public static Connection ConnectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection c = (Connection) DriverManager.getConnection("jdbc:sqlserver://" + dbHost + ":" + dbPort + ";"
					+ "databaseName=" + dbName + ";" + "user=" + dbUser + ";" + "password=" + dbPass);
			System.out.println("Opened database successfully");
			return c;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}
	}

	public static ObservableList<Teilnehmerliste> getDataTeilnehmerliste() {

		Connection c = ConnectDB();
		ObservableList<Teilnehmerliste> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = c.prepareStatement(
					"select SpielerNr, Name, Vorname, EloZahl, GruppenName \r\n" + 
					"From dbo.Spieler , dbo.Gruppen \r\n" + 
					"Where EloZahl between MinEloZahl and MaxEloZahl\r\n" + 
					"Order by SpielerNr ASC");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Teilnehmerliste(Integer.parseInt(rs.getString("SpielerNr")), rs.getString("Name"),
						rs.getString("Vorname"), Integer.parseInt(rs.getString("EloZahl")), rs.getString("GruppenName")));
			}
		} catch (Exception e) {
			System.out.println("Error");
		}

		return list;
	}

	public static int getDataSpielerAnzahl() {

		Connection c = ConnectDB();
		int count = 0;
		try {
			PreparedStatement ps = c.prepareStatement("select count(*) from dbo.Spieler");
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error");
		}

		return count;
	}

	public static ObservableList<Gruppen> getDataGruppe(String gruppenID) {
		Connection c = ConnectDB();
		ObservableList<Gruppen> list = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = c.prepareStatement(
					"select SpielerNr, Name, Vorname, EloZahl\r\n" + 
					"From dbo.Spieler , dbo.Gruppen \r\n" + 
					"Where EloZahl between MinEloZahl and MaxEloZahl\r\n" + 
					"And GruppenID = '" + gruppenID + "'\r\n" + 
					"Order by SpielerNr ASC");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Gruppen(Integer.parseInt(rs.getString("SpielerNr")), rs.getString("Name"),
						rs.getString("Vorname"), Integer.parseInt(rs.getString("EloZahl"))));
			}
		} catch (Exception e) {
			System.out.println("Error");
		}

		return list;
	}
	
}
