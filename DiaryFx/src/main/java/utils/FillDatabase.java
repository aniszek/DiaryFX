package utils;

/**
 * Created by anisz
 */

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.io.InputStream;

import javax.persistence.EntityManager;

import model.Category;
import model.Event;
import model.Person;

public class FillDatabase {

	public static void fillDatabase(EntityManager em) {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		File fileKJobs = new File(classLoader.getResource("icons/KosmogramJobsa.gif").getFile());
    	InputStream fileInputStream = FillDatabase.class.getResourceAsStream("/icons/KosmogramJobsa.gif"); // to jest ok
   	
    	File fileLew = new File(classLoader.getResource("icons/lew.jpg").getFile());
    	InputStream fileInputStream2 = FillDatabase.class.getResourceAsStream("/icons/lew.jpg"); 
    	
    	File fileKJobs2 = new File(classLoader.getResource("icons/JobsGirl.gif").getFile());
    	InputStream fileInputStream3 = FillDatabase.class.getResourceAsStream("/icons/JobsGirl.gif"); 
    	
    	File fileFryzjer = new File(classLoader.getResource("icons/lewFryzjer.jpg").getFile());
    	InputStream fileInputStream4 = FillDatabase.class.getResourceAsStream("/icons/lewFryzjer.jpg"); 
    	
        byte[] bFileKJobs = new byte[(int) fileKJobs.length()];
        byte[] bFile2Lew = new byte[(int) fileLew.length()];
        byte[] bFile3KJobs = new byte[(int) fileKJobs2.length()];
        byte[] bFile4Fryzjer = new byte[(int) fileFryzjer.length()];

        try {
	     fileInputStream.read(bFileKJobs);
	     fileInputStream.close();
	     fileInputStream2.read(bFile2Lew);
	     fileInputStream2.close();
	     fileInputStream3.read(bFile3KJobs);
	     fileInputStream3.close();
	     fileInputStream4.read(bFile4Fryzjer);
	     fileInputStream4.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
        
		Person person = new Person();
		person.setName("Steve");
		person.setSurname("Jobs");

		Person person2 = new Person();
		person2 .setName("Kevin");
		person2 .setSurname("Mitnick");

		Category category1 = new Category();
		category1.setName("Narodziny");
		
		Category category2 = new Category();
		category2.setName("Tranzyt Słońca");

		Category category3 = new Category();
		category3.setName("Progresja słoneczna");
		

		Event event1 = new Event();
		Event event2 = new Event();
		Event event3 = new Event();
		Event event4 = new Event();

		event1.setTitle("Miłość");
		event2.setTitle("Nagła wizyta u fryzjera");
		event3.setTitle("Narodziny Mitnicka");
		event4.setTitle("Narodziny Jobsa");
		event1.setPerson(person);
		event2.setPerson(person2);
		event3.setPerson(person2);
		event4.setPerson(person);
		event1.setDescription("Progresja Słońca przez Księżyc w siódmym domu");
		event2.setDescription("Słońce kwadratura Uran");
		event3.setDescription("Narodziny");
		event4.setDescription("Narodziny");
		event1.setCategory(category3);
		event2.setCategory(category2);
		event3.setCategory(category1);
		event4.setCategory(category1);
		event1.setImage(bFile3KJobs);
		event2.setImage(bFile4Fryzjer);
		event3.setImage(bFile2Lew);
		event4.setImage(bFileKJobs);
		event1.setRating(5);
		event2.setRating(2);
		event3.setRating(3);
		event4.setRating(4);
		
		LocalDate JobsBirth = LocalDate.of(1955, Month.FEBRUARY, 24);
		event4.setReleaseDate(JobsBirth);
		
		LocalDate MitnickBirth = LocalDate.of(1963, Month.AUGUST, 6);
		event3.setReleaseDate(MitnickBirth);
		
		LocalDate JobsMarriage = LocalDate.of(1991, Month.MARCH, 18);
		event1.setReleaseDate(JobsMarriage);
		
		LocalDate MitnickHairdresser = LocalDate.of(1983, Month.NOVEMBER, 27);
		event2.setReleaseDate(MitnickHairdresser);

		em.getTransaction().begin();

		em.persist(person);
		em.persist(person2);
		em.persist(category1);
		em.persist(category2);
		em.persist(category3);
		em.persist(event1);
		em.persist(event2);
		em.persist(event3);
		em.persist(event4);

		em.getTransaction().commit();
	}

}
