package controllers;

import converters.EventConverter;
import converters.PictureConverter;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Stage.*;
import model.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import utils.ApplicationException;
import utils.DialogsUtils;
import utils.Queries;
import converters.PictureConverter;

/**
 * Developed by anisz
 */
public class PictureController {

	@FXML
	private ImageView imageView;
	@FXML
	private Button chooser;

	private PictureModel pictureModel;

	@FXML
	public void initialize() { 
		this.pictureModel = new PictureModel();
		try {
			this.pictureModel.init();
		} catch (ApplicationException e) {
			DialogsUtils.errorDialog(e.getMessage());
		}
	}

	protected void setImage(Image image) {
		this.imageView.setImage(image);
	}

	public PictureModel getPictureModel() {
		return pictureModel;
	}
}
