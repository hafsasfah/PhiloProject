package database;
import java.sql.*;

import models.Quotes;

public class QuotesDB {
	
	Connection connection;

	public QuotesDB() {		
		try {
			String url = "jdbc:postgresql://localhost/PhiloProj";
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
			String insertsql = "CREATE TABLE \"Quotes\" (\"ID\" serial NOT NULL,\"AuthorName\" character varying(50), "
					+ "\"Quote\" character varying, CONSTRAINT \"PK\" PRIMARY KEY (\"ID\")) "
					+ "WITH ( OIDS=FALSE ); ALTER TABLE \"Quotes\" OWNER TO postgres;";
			statement.execute(insertsql);
		}
			catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public boolean createQuote(Quotes quote) {
		try {
			Statement statement = connection.createStatement();
			String createGameRow = String.format
					("INSERT INTO \"Quotes\" (\"AuthorName\", \"Quote\") VALUES ('%s', '%s');", 
							quote.getQuote(), quote.getAuthor());
			statement.execute(createGameRow);
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public int getQuote() { // add random logic
		try {
			Statement statement = connection.createStatement();
			String query = String.format("SELECT \"ID\" FROM \"Quotes\" WHERE \"Name\" = '%s';", name);
			ResultSet results = statement.executeQuery(query);
			
			while (results.next()) {
				int gameID = results.getInt(1);
				String gameName = results.getString(2);
				aPlayers currentPlayer = playerRepo.get(results.getInt(3));
				
				Game savedGame = new Game(gameID, gameName);		
				
				return gameID;
			}
			
			
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

	public boolean delete(aGame game) { // will not implement
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