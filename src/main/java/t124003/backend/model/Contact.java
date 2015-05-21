package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class Contact {
    private Integer contact;
    private Integer subjectFk;
    private Integer contactTypeFk;
    private String valueText;
    private Integer orderby;
    private Integer subjectTypeFk;
    private String note;

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Integer getSubjectFk() {
        return subjectFk;
    }

    public void setSubjectFk(Integer subjectFk) {
        this.subjectFk = subjectFk;
    }

    public Integer getContactTypeFk() {
        return contactTypeFk;
    }

    public void setContactTypeFk(Integer contactTypeFk) {
        this.contactTypeFk = contactTypeFk;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public Integer getSubjectTypeFk() {
        return subjectTypeFk;
    }

    public void setSubjectTypeFk(Integer subjectTypeFk) {
        this.subjectTypeFk = subjectTypeFk;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact1 = (Contact) o;

        if (contact != null ? !contact.equals(contact1.contact) : contact1.contact != null) return false;
        if (contactTypeFk != null ? !contactTypeFk.equals(contact1.contactTypeFk) : contact1.contactTypeFk != null)
            return false;
        if (note != null ? !note.equals(contact1.note) : contact1.note != null) return false;
        if (orderby != null ? !orderby.equals(contact1.orderby) : contact1.orderby != null) return false;
        if (subjectFk != null ? !subjectFk.equals(contact1.subjectFk) : contact1.subjectFk != null) return false;
        if (subjectTypeFk != null ? !subjectTypeFk.equals(contact1.subjectTypeFk) : contact1.subjectTypeFk != null)
            return false;
        if (valueText != null ? !valueText.equals(contact1.valueText) : contact1.valueText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contact != null ? contact.hashCode() : 0;
        result = 31 * result + (subjectFk != null ? subjectFk.hashCode() : 0);
        result = 31 * result + (contactTypeFk != null ? contactTypeFk.hashCode() : 0);
        result = 31 * result + (valueText != null ? valueText.hashCode() : 0);
        result = 31 * result + (orderby != null ? orderby.hashCode() : 0);
        result = 31 * result + (subjectTypeFk != null ? subjectTypeFk.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
