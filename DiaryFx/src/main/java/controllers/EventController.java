package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.*;
import utils.ApplicationException;
import utils.DialogsUtils;
import java.io.File;
import java.io.IOException;

/**
 * Developed by anisz
 */
public class EventController {

	@FXML
	private Button addButton;
	@FXML
	private ComboBox<CategoryFx> categoryComboBox;
	@FXML
	private ComboBox<PersonFx> personComboBox;
	@FXML
	private TextArea descTextArea;
	@FXML
	private Slider ratingSlider;
	@FXML
	private DatePicker releaseDatePicker;
	@FXML
	private TextField titleTextField;
	@FXML
	private ImageView imageView;
	@FXML
	Button changeButton; 

	private EventModel eventModel;

	@FXML
	public void initialize() {
		this.eventModel = new EventModel();
		try {
			this.eventModel.init();
		} catch (ApplicationException e) {
			DialogsUtils.errorDialog(e.getMessage());
		}
		bindings();
		validation();
		
		changeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				Stage stage = new Stage();
				FileChooser fileChooser = new FileChooser();
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					Image image = new Image(file.toURI().toString());
					imageView.setImage(image);
				}
			}
		});
	}

	private void validation() {
		this.addButton.disableProperty()
				.bind(this.personComboBox.valueProperty().isNull().or(this.categoryComboBox.valueProperty().isNull())
						.or(this.titleTextField.textProperty().isEmpty()).or(this.descTextArea.textProperty().isEmpty())
						.or(this.releaseDatePicker.valueProperty().isNull()));
	}

	public void bindings() {
		this.categoryComboBox.setItems(this.eventModel.getCategoryFxObservableList());
		this.personComboBox.setItems(this.eventModel.getPersonFxObservableList());

		this.categoryComboBox.valueProperty()
				.bindBidirectional(this.eventModel.getEventFxObjectProperty().categoryFxProperty());
		this.personComboBox.valueProperty()
				.bindBidirectional(this.eventModel.getEventFxObjectProperty().personFxProperty());

		this.titleTextField.textProperty()
				.bindBidirectional(this.eventModel.getEventFxObjectProperty().titleProperty());
		this.descTextArea.textProperty()
				.bindBidirectional(this.eventModel.getEventFxObjectProperty().descriptionProperty());
		this.ratingSlider.valueProperty()
				.bindBidirectional(this.eventModel.getEventFxObjectProperty().ratingProperty());
		this.releaseDatePicker.valueProperty()
				.bindBidirectional(this.eventModel.getEventFxObjectProperty().releaseDateProperty());
		this.imageView.imageProperty().bindBidirectional(this.eventModel.getEventFxObjectProperty().imageFxProperty());
	}

	public void addEventOnAction() {
		try {
			this.eventModel.saveEventInDataBase();
			clearFields();
		} catch (ApplicationException e) {
			DialogsUtils.errorDialog(e.getMessage());
		}
	} 

	private void clearFields() {
		this.personComboBox.getSelectionModel().clearSelection();
		this.categoryComboBox.getSelectionModel().clearSelection();
		this.titleTextField.clear();
		this.descTextArea.clear();
		this.ratingSlider.setValue(1);
		this.releaseDatePicker.getEditor().clear();
		this.imageView.setImage(null);
	}

	public EventModel getEventModel() {
		return eventModel;
	}
}
 