package it.polito.tdp.alien;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.Dizionario;
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
		txtInput.clear();
	}

	@FXML
	void doTranslate(ActionEvent event)
	{
		String input = txtInput.getText().toLowerCase();
		input.trim();
		
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
				
				textArea.setText(String.format("PAROLA AGGIUNTA: %s -> %s",sub[0],sub[1]));
			}
			else 
				textArea.setText("FORMATO TESTO INPUT ERRATO!!"); 
		}
		//cerca traduzione
		else
		{
			textArea.setText(String.format(" PAROLA CERCATA: %s\n -> TRADUZIONI: ", input));

			if(input.contains("?"))
			{
				List<String> list = this.model.cercaParola(input);
				for (String	trovato : list)
				{
					List<String> output = this.model.traduci(trovato);
					textArea.appendText(""+output);
					return;
				}
			} 
			
			List<String> output = this.model.traduci(input);
			if(output == null)
				textArea.appendText("ANCORA NESSUNA TRADUZIONE PRESENTE!"); 
			else for (String s : output)
				textArea.appendText("\n- " + s); 
		}
		txtInput.clear();
	}
	@FXML
	private void doElencoParole()
	{
		textArea.setText("DIZIONARIO:\n" + this.model.stampa()); 
		txtInput.clear();
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
