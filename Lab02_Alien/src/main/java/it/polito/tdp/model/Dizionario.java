package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Model 
 *
 */
public class Dizionario
{
	Map<String,List<String>> parole;
	
	public Dizionario()
	{
		this.parole = new HashMap<>();
	}

	public void addWord(String alienWord, String translation) 
	{
		if(this.parole.get(alienWord) == null)
			this.parole.put(alienWord, new ArrayList<String>());
		if(!this.parole.get(alienWord).contains(translation))
			this.parole.get(alienWord).add(translation);
	}

	public void reset()
	{
		this.parole.clear();
	}

	public List<String> traduci(String input)
	{
		return this.parole.get(input);
	}
	
	public String stampa()
	{
		ArrayList<String> keys = new ArrayList<>(this.parole.keySet());
		keys.sort((s1,s2)->s1.compareTo(s2));
		
		String s = "\n";
		
		for (String key : keys)
		{
			ArrayList<String> traduzioni = new ArrayList<>(this.parole.get(key));
			traduzioni.sort((s1,s2)->s1.compareTo(s2));
			s += "- " + key + ": ";
			for (String trad : traduzioni)
			{
				s.trim();
				s += trad + ", ";
			}
		}
		return s.isEmpty() ? "\nDIZIONARIO VUOTO!" : (s.substring(0,s.length()-2) + ";");
	} 
}
