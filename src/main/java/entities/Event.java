package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.Column;
@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "EV_ID", updatable = false, nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	@Column(name = "EV_VERSION")
	private int version;

	@Column(name = "EV_DATE")
	private LocalDate date;

	@Column(name = "EV_LOCATION")
	private String location;

	@Column(name = "EV_TITLE")
	private String title;

	@Column(name = "EV_SPEAKER")
	private String speaker;

	@Column(name = "EV_IMAGE")
	private String image;

	@Column(name = "EV_DETAILS")
	private String details;



	// region Constructors
	public Event() {
	}

	public Event(String title, String speaker, LocalDate date, String details, String location) {
		this.date = date;
		this.location = location;
		this.title = title;
		this.speaker = speaker;
		this.details = details;
	}
	// endregion

	// region Getter and Setter
	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
	// endregion

	// region equals, hashCode, toString
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Event)) {
			return false;
		}
		Event other = (Event) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (location != null && !location.trim().isEmpty())
			result += "location: " + location;
		if (title != null && !title.trim().isEmpty())
			result += ", title: " + title;
		if (speaker != null && !speaker.trim().isEmpty())
			result += ", speaker: " + speaker;
		if (image != null && !image.trim().isEmpty())
			result += ", image: " + image;
		if (details != null && !details.trim().isEmpty())
			result += ", Details: " + details;
		return result;
	}

	// endregion

}