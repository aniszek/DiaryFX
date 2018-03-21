package Diary;

/**
 * Developed by anisz
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import controllers.CategoryController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Category;
import model.Event;
import model.Person;
import utils.FillDatabase;
import utils.FxmlUtils;
import utils.PersistenceManager;
import utils.Queries;

public class Main extends Application {

	private static final String BORDER_PANE_MAIN_FXML = "../fxml/BorderPaneMain.fxml";

	public static void main(String[] args) {

		EntityManagerFactory emf = PersistenceManager.getInstance().getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
		FillDatabase.fillDatabase(em);

		launch(args);
		
		em.close();
		PersistenceManager.getInstance().closeEntityManagerFactory();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);
		Scene scene = new Scene(borderPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("tittle.application"));
		primaryStage.show();
	}
}