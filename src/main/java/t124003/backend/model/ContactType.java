package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class ContactType {
    private Integer contactType;
    private String typeName;

    public Integer getContactType() {
        return contactType;
    }

    public void setContactType(Integer contactType) {
        this.contactType = contactType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactType that = (ContactType) o;

        if (contactType != null ? !contactType.equals(that.contactType) : that.contactType != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactType != null ? contactType.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
