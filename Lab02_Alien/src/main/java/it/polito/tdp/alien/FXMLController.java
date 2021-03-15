package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Dizionario;
import it.polito.tdp.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController
{
	Dizionario model;
	
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TextField txtInput;
	@FXML
	private Button btnTranslate;
	@FXML
	private TextArea textArea;

	@FXML
	void doReset(ActionEvent event)
	{
		model.reset();
		
		textArea.setText("DATABASE RESETTATO!"); 
	}

	@FXML
	void doTranslate(ActionEvent event)
	{
		String input = txtInput.getText();
		
		//TODO: controlla validita testo
		
		//agg. al dizionario
		if(input.contains(" "))
		{
			String[] sub = null;
			try { sub = input.split(" ",2); } 
			catch (Exception e) { textArea.setText("FORMATO TESTO INPUT ERRATO!!"); }
			
			if(sub.length == 2 && !sub[0].equals("") && !sub[1].equals(""))
			{
				model.addWord(sub[0], sub[1]);
				
				textArea.setText(String.format("parola aggiunta: %s traduzione: %s",sub[0].toUpperCase(),sub[1])); 
			}
			else 
			{
				textArea.setText("FORMATO TESTO INPUT ERRATO!!"); 
			}
		}
		//cerca traduzione
		else
		{
			Parola output = this.model.traduci(input);
			textArea.setText(String.format("PAROLA CERCATA: %s,\nTRADUZIONE: %s", input, output != null ? output.getTraduzione() : "TRADUZIONE NON TROVATA")); 
		}
	}
	@FXML
	private void doElencoParole()
	{
		textArea.setText("DIZIONARIO:\n" + this.model.elencoParole()); 
	}

	@FXML
	void initialize()
	{
		assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
		assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'Scene.fxml'.";

	}

	public void setModel(Dizionario model)
	{
		this.model = model;
	}
}
