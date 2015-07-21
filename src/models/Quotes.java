package models;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Quotes {
	String quote;
	String authorName;
	TreeMap<String, String> entry = new TreeMap();
	
	/*
	 * Add a Getter returning the key/value pairs
	   Add a Setter setting the key/value pairs
	 * Set set = tmap.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
         System.out.println(mentry.getValue());
	 */
	
	
	public Quotes() {
		
	}
	
	public TreeMap getEntry() {
		return entry;
	}
	
	public void setEntry(String quote, String author) {
		entry.put(author, quote);
		
	}

	public String getQuote() {
		return quote;
	}
	
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String author) {
		this.authorName = author;
	}
}