package t124003.backend.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Raviool on 21.05.2015.
 */
public class Person {
    private Integer person;
    private String firstName;
    private String lastName;
    private String identityCode;
    private Date birthDate;
    private Integer createdBy;
    private Integer updatedBy;
    private Timestamp created;
    private Timestamp updated;

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
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

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person1 = (Person) o;

        if (birthDate != null ? !birthDate.equals(person1.birthDate) : person1.birthDate != null) return false;
        if (created != null ? !created.equals(person1.created) : person1.created != null) return false;
        if (createdBy != null ? !createdBy.equals(person1.createdBy) : person1.createdBy != null) return false;
        if (firstName != null ? !firstName.equals(person1.firstName) : person1.firstName != null) return false;
        if (identityCode != null ? !identityCode.equals(person1.identityCode) : person1.identityCode != null)
            return false;
        if (lastName != null ? !lastName.equals(person1.lastName) : person1.lastName != null) return false;
        if (person != null ? !person.equals(person1.person) : person1.person != null) return false;
        if (updated != null ? !updated.equals(person1.updated) : person1.updated != null) return false;
        if (updatedBy != null ? !updatedBy.equals(person1.updatedBy) : person1.updatedBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = person != null ? person.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (identityCode != null ? identityCode.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        return result;
    }
}
