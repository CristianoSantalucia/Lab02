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
}
