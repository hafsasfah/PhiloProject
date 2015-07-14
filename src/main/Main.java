package main;

import database.QuotesDB;

public class Main {

	public static void main(String[] args) {
		QuotesDB qDB = new QuotesDB();
		qDB.buildQuotesTable();

	}

}
