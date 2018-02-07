package entities;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


import enums.Participating;

import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
@Entity
public class Registration implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "REG_ID", updatable = false, nullable = false)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Version
	@Column(name = "REG_VERSION")
	private int version;

	@ManyToOne
   	private Event event;

	@ManyToOne
	private Person person;

    @Enumerated(EnumType.STRING)
    @Column(name = "REG_IS_ATTENDING")
    private Participating isAttending;

    @Column(name = "REG_CREATE_DATE")
    private LocalDateTime createDate;



    // region Constructors
	public Registration() {
		createDate = LocalDateTime.now();
	}

	public Registration(Person person, Event event, Participating isAttending) {
		this();
		this.person = person;
		this.isAttending = isAttending;
		this.event = event;
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

	public Participating getIsAttending() {
		return isAttending;
	}

	public void setIsAttending(Participating isAttending) {
		this.isAttending = isAttending;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(final Event event) {
		this.event = event;
	}
    public Person getPerson() {
        return this.person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }

    // endregion

	// region equals, hashCode, toString
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Registration)) {
			return false;
		}
		Registration other = (Registration) obj;
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
		result += isAttending;
		return result;
	}
	// endregion

}
