package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

/**
 * Created by anisz
 */
public class TopMenuButtonsController {

	private static final String EVENTS_LIST_FXML = "../fxml/EventList.fxml";
	private static final String ADD_EVENT_FXML = "../fxml/AddEvent.fxml";
	private static final String ADD_CATEGORY_FXML = "../fxml/AddCategory.fxml";
	private static final String ADD_PERSON_FXML = "../fxml/AddPerson.fxml";
	private static final String CHANGE_LANGUAGE_FXML = "../fxml/ChangeLanguage.fxml";
	
	private MainController mainController;


	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	private ToggleGroup toggleButtons;

	@FXML
	public void openListEvents() {
		mainController.setCenter(EVENTS_LIST_FXML);
		mainController.clearLeft();
	}

	@FXML
	public void addEvent() {
		mainController.setLeft(ADD_EVENT_FXML);
		mainController.clearCenter();
	}

	@FXML
	public void addCategory() {
		mainController.setCenter(ADD_CATEGORY_FXML);
		mainController.clearLeft();
	}

	@FXML
	public void addPerson() {
		mainController.setCenter(ADD_PERSON_FXML);
		mainController.clearLeft();
	}

	
	@FXML
	public void changeLanguage() {
		mainController.setCenter(CHANGE_LANGUAGE_FXML);
		mainController.clearLeft();
		
	}
}
