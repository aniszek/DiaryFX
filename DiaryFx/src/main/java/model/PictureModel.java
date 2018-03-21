package model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.ApplicationException;
import utils.Queries;

import java.util.List;

import converters.PersonConverter;
import converters.EventConverter;
import converters.CategoryConverter;

/**
 * Created by anisz
 */
public class PictureModel {

//    private ObjectProperty<EventFx> eventFxObjectProperty = new SimpleObjectProperty<>(new EventFx());
//
//
//
    public void init() throws ApplicationException {
        initPicture();

    }


    private void initPicture() throws ApplicationException {
//    	  // load the image
//        Image image;
//
//			image = new Image("file:../icons/Kosmo.gif");
////			image = new Image("@../../../../../Users/Kot/Desktop/Kosmo.gif");
//			
//        // simple displays ImageView the image as is
//        ImageView iv1 = new ImageView();
//        iv1.setImage(image);
    }
//
//    public void saveEventInDataBase() throws ApplicationException {
//        Event event = EventConverter.convertToEvent(this.getEventFxObjectProperty());
//
//        Category category = Queries.findById(Category.class, this.getEventFxObjectProperty().getCategoryFx().getId());
//
//        Person person = Queries.findById(Person.class, this.getEventFxObjectProperty().getPersonFx().getId());
//
//        event.setCategory(category);
//        event.setPerson(person);
//
//        Queries.createOrUpdate(event);
//    }
//
//
//    public EventFx getEventFxObjectProperty() {
//        return eventFxObjectProperty.get();
//    }
//
//    public ObjectProperty<EventFx> eventFxObjectPropertyProperty() {
//        return eventFxObjectProperty;
//    }
//
//    public void setEventFxObjectProperty(EventFx eventFxObjectProperty) {
//        this.eventFxObjectProperty.set(eventFxObjectProperty);
//    }


}