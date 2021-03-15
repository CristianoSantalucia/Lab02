package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FXMLController
{
	Dizionario model;
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private Button btnTranslate;

	
	
	@FXML
	void doTranslate(ActionEvent event)
	{
		
	}

	@FXML
	void doReset(ActionEvent event)
	{

	}

	
	
	
	@FXML
	void initialize()
	{
		assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
	}
	
	public void setModel(Dizionario t)
	{
		this.model = t;
	}
}