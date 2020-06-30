package springBoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MovieRatings {
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=1, max=150)
	private String movieTitle;
	
	@NotNull
	private int rating;
	
	@NotNull
	@Size(min=1, max=150)
	private String userName;
	
	@NotNull
	private String dateTime;

	public MovieRatings() {
		id = 0;
		movieTitle = null;
		rating = 0;
		userName = null;
		dateTime = null;
	}
	
	public MovieRatings(long id, String movieTitle, int rating, String userName, String dateTime) {
		super();
		this.id = id;
		this.movieTitle = movieTitle;
		this.rating = rating;
		this.userName = userName;
		this.dateTime = dateTime;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
