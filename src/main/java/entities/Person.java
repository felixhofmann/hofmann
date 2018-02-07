package entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(name = "PE_ID", updatable = false, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "PE_VERSION")
    private int version;

    @Column(name = "PE_FIRST_NAME")
    private String firstName;

    @Column(name = "PE_LAST_NAME")
    private String lastName;

    @Column(name = "PE_EMAIL", unique = true)
    private String email;



    public Person() {
    }

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }



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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (id != null)
            result += "id: " + id;
        if (firstName != null && !firstName.trim().isEmpty())
            result += firstName;
        if (lastName != null && !lastName.trim().isEmpty())
            result += " " + lastName;
        if (email != null && !email.trim().isEmpty())
            result += " (" + email + ")";
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
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
}