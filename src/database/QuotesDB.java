package database;
import java.sql.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import models.Quotes;

public class QuotesDB {
	
	Connection connection;

	public QuotesDB() {
		// Create a database named PhiloProject before creating tables
		try {
			String url = "jdbc:postgresql://localhost/PhiloProject"; // Database name
			String username = "postgres";
			String password = "password";
				
			connection = DriverManager.getConnection(url, username, password);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buildQuotesTable() {
		try {
			Statement statement = connection.createStatement();
			String buildTable = "CREATE TABLE \"Quotes\" (\"ID\" serial NOT NULL,\"AuthorName\" character varying(50), "
					+ "\"Quote\" character varying, CONSTRAINT \"PK\" PRIMARY KEY (\"ID\")) "
					+ "WITH ( OIDS=FALSE ); ALTER TABLE \"Quotes\" OWNER TO postgres;";
			statement.execute(buildTable);
		}
			catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public boolean createQuote(Quotes quote) {
		try {
			Statement statement = connection.createStatement();
			String createQuoteRow = String.format
					("INSERT INTO \"Quotes\" (\"AuthorName\", \"Quote\") VALUES ('%s', '%s');", 
							quote.getQuote(), quote.getAuthorName());
			statement.execute(createQuoteRow);
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int getQuote(Quotes authorName) { // add random logic
		try {
			Statement statement = connection.createStatement();
			String query = String.format("SELECT \"Quote\" FROM \"Quotes\" ORDER BY RANDOM() LIMIT 1;");
			ResultSet results = statement.executeQuery(query);		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean update(aGame game) {
		try {
			Statement statement = connection.createStatement();
			String query = String.format("UPDATE \"Game\" SET \"Completed\" = true WHERE \"Name\" = '%s';", game.getName());
			statement.execute(query);
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(game) { // will not implement
		return false;
	}

	public aGame getGame(int gameID) { // cannot do until Game class is completed
		try {
			Statement statement = connection.createStatement();
			String query = String.format("SELECT \"Name\" FROM \"Game\" WHERE \"ID\" = %d", gameID );
			ResultSet results = statement.executeQuery(query);
			
			while ( results.next() )
			{
				String gameName = results.getString(1);
				
				//Game savedGame = new Game();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}	
	}