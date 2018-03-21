package model;

/**
 * Created by anisz
 */

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javafx.scene.image.Image;

@Entity
public class Event implements BaseModel{
	
    public Event() {
    }

    public static final String PERSON_ID = "PERSON_ID";
    public static final String CATEGORY_ID = "CATEGORY_ID";
 
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name=PERSON_ID) //, nullable = false
    private Person person;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name=CATEGORY_ID)
    private Category category;
    
    @Column(name = "TITLE", nullable  = false)
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;

    @Column(name = "RATING", precision = 1)
    private int rating;

    @Column(name = "ADDED_DATE")
    private LocalDate addedDate;

	@Column(name = "IMAGE")
    private byte[] image;
	
    public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
    
    public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDate addedDate) {
		this.addedDate = addedDate;
	}
	
	@Override
	public String toString(){
		return title + " ";
	}

}
