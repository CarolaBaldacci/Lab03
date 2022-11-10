package it.polito.tdp.spellchecker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;

public class FXMLController {

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
    private MenuButton txtLanguage;

    @FXML
    private Label txtTempo;

    @FXML
    void doClear(ActionEvent event) {

    	txtCorreggere.clear();
    	txtCorretto.clear();
    	txtErrori.setDisable(true);
    	txtLanguage.disarm();
    	txtTempo.setDisable(true);
    	
    }

    @FXML
    void doSpell(ActionEvent event) {

    }

}


