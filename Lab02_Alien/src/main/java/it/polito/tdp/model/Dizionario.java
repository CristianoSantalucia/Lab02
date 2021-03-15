package it.polito.tdp.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Model 
 *
 */
public class Dizionario
{
	Map<String,Parola> parole;
	
	public Dizionario()
	{
		this.parole = new HashMap<>();
	}

	public void addWord(String alienWord, String translation) 
	{
		this.parole.put(alienWord,new Parola(alienWord, translation));
	}

	public void reset()
	{
		this.parole.clear();
	}

	public Parola traduci(String input)
	{
		return this.parole.get(input);
	}
	
	public String elencoParole()
	{
		String s = "";
		for (String key : this.parole.keySet())
			s += String.format("- %s -> %s\n",key,this.parole.get(key).traduzione);
		return s;
	}
}
