package it.polito.tdp.spellchecker;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import it.polito.tdp.spellercheck.model.Dictionary;
import it.polito.tdp.spellercheck.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

	private Dictionary dizionario;
	private List<String> inputTextList;
	
    @FXML
    private Button btnClear;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea txtCorreggere;

    @FXML
    private TextArea txtCorretto;

    @FXML
    private Label txtErrori;

    @FXML
    private ComboBox<String> boxLanguage;

    @FXML
    private Label txtTempo;
   
    
    @FXML
    void initialize() {
        assert boxLanguage != null : "fx:id=\"boxLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorreggere != null : "fx:id=\"txtDaCorreggere\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpell != null : "fx:id=\"spellCheckButton\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretto != null : "fx:id=\"txtCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrori != null : "fx:id=\"lblErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"clearTextButton\" was not injected: check your FXML file 'Scene.fxml'.";
        
    }
    
    
    public void setModel(Dictionary model) {
    	txtCorreggere.setDisable(false);
    	txtCorreggere.setText("Choose the language");
    	txtCorretto.setDisable(false);
    	boxLanguage.getItems().addAll("English","Italian");
    	this.dizionario=model;
    }
    
    
    @FXML
    void doClear(ActionEvent event) {

    	txtCorreggere.clear();
    	txtCorretto.clear();
    	txtErrori.setDisable(true);
    	boxLanguage.disarm();
    	txtTempo.setDisable(true);
    	
    }

    @FXML
    void doSpell(ActionEvent event) {

    	txtCorretto.clear();
    	inputTextList= new LinkedList<String>();
    	
    	//controllo sulla ligua
    	if(boxLanguage.getValue()==null) {
    		txtCorreggere.setText("Selezionare una lingua");
    		return;
    	}
    	if(!dizionario.loadDictionary(boxLanguage.getValue())) {
    		txtCorreggere.setText("Errore nel caricamento del dizionario");
    		return;
    	}
    	
    	String inputText=txtCorreggere.getText();
    	
    	//controllo sull'input
    	if(inputText.isEmpty()) {
    		txtCorreggere.setText("Inserire un testo da correggere!");
    		return;
    	}
    	
    	inputText=inputText.replace("\n"," " );
    	inputText=inputText.replaceAll("[.,\\/#!?$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	
    	StringTokenizer st = new StringTokenizer(inputText, " ");
		while (st.hasMoreTokens()) {
			inputTextList.add(st.nextToken());
		}
    	
    	List<RichWord> result;
    	result= dizionario.spellCheckText(inputTextList);
    	int numError=0;
    	StringBuilder richText = new StringBuilder();
    	for(RichWord rw : result) {
    		if(!rw.isCorretta()) {
    			numError++;
    			richText.append(rw.getParola()+" \n");
    		}
    	}
    	txtCorretto.setText(richText.toString());
    	txtErrori.setText("The text contains "+numError+" errors");
    	
    }
    
    


}


