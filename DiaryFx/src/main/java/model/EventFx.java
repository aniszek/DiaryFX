package model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.time.LocalDate;

/**
 * Developed by anisz
 */
public class EventFx {

	private IntegerProperty id = new SimpleIntegerProperty();
	private ObjectProperty<CategoryFx> categoryFx = new SimpleObjectProperty<>();
	private ObjectProperty<PersonFx> personFx = new SimpleObjectProperty<>();
	private SimpleStringProperty title = new SimpleStringProperty();
	private SimpleStringProperty description = new SimpleStringProperty();
	private ObjectProperty<LocalDate> releaseDate = new SimpleObjectProperty<>();
	private IntegerProperty rating = new SimpleIntegerProperty();
	private ObjectProperty<LocalDate> addedDate = new SimpleObjectProperty(LocalDate.now());
	private ObjectProperty<Image> imageFX = new SimpleObjectProperty<>();

	public int getId() {
		return id.get();
	}

	public IntegerProperty idProperty() {
		return id;
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public CategoryFx getCategoryFx() {
		return categoryFx.get();
	}

	public ObjectProperty<CategoryFx> categoryFxProperty() {
		return categoryFx;
	}
 
	public void setCategoryFx(CategoryFx categoryFx) {
		this.categoryFx.set(categoryFx);
	}

	public PersonFx getPersonFx() {
		return personFx.get();
	}

	public ObjectProperty<PersonFx> personFxProperty() {
		return personFx;
	}

	public void setPersonFx(PersonFx personFx) {
		this.personFx.set(personFx);
	}

	public String getTitle() {
		return title.get();
	}

	public SimpleStringProperty titleProperty() {
		return title;
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public String getDescription() {
		return description.get();
	}

	public SimpleStringProperty descriptionProperty() {
		return description;
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	public int getRating() {
		return rating.get();
	}

	public IntegerProperty ratingProperty() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating.set(rating);
	}

	public LocalDate getReleaseDate() {
		return releaseDate.get();
	}

	public ObjectProperty<LocalDate> releaseDateProperty() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate.set(releaseDate);
	}

	public LocalDate getAddedDate() {
		return addedDate.get();
	}

	public ObjectProperty<LocalDate> addedDateProperty() {
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate) {
		this.addedDate.set(addedDate);
	}
	
	public Image getImageFX() {
		return imageFX.get();
	}

	public ObjectProperty<Image> imageFxProperty() {
		return imageFX;
	} 
 
	public void setImageFX(Image imageFx) {
		this.imageFX.set(imageFx);
	}			


	@Override
	public String toString() {
		return "EventFx{" + "id=" + id.get() + ", categoryFx=" + categoryFx.get() + ", personFx=" + personFx.get()
				+ ", title=" + title.get() + ", description=" + description.get() + ", releaseDate=" + releaseDate.get()
				+  ", rating=" + rating.get() + ", addedDate=" + addedDate.get() + '}';
	}
}
