package converters;

import model.Event;
import model.EventFx;

public class EventConverter {

	/**
	 * Developed by anisz
	 */

	public static Event convertToEvent(EventFx eventFx) {
		Event event = new Event();
		event.setId(eventFx.getId());
		event.setTitle(eventFx.getTitle());
		event.setDescription(eventFx.getDescription());
		event.setRating(eventFx.getRating());
		event.setReleaseDate(eventFx.getReleaseDate());
		event.setAddedDate(eventFx.getAddedDate());
		event.setImage(PictureConverter.convertToByteArray(eventFx.getImageFX()));
		return event;
	}
	
	public static EventFx convertToEventFx(Event event) {
		EventFx eventFx = new EventFx();
		eventFx.setId(event.getId());
		eventFx.setTitle(event.getTitle());
		eventFx.setDescription(event.getDescription());
		eventFx.setRating(event.getRating());
    	eventFx.setReleaseDate(event.getReleaseDate());
		eventFx.setPersonFx(PersonConverter.convertToPersonFx(event.getPerson()));
		eventFx.setCategoryFx(CategoryConverter.convertToCategoryFx(event.getCategory()));
		eventFx.setImageFX(PictureConverter.convertToJavaFXImage(event.getImage(), 300, 300)); 
		return eventFx;

	}
}
