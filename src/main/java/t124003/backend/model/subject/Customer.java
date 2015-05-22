package t124003.backend.model.subject;

/**
 * Created by Raviool on 21.05.2015.
 */
public class Customer {
    private Integer customer;
    private Integer subjectFk;
    private Integer subjectTypeFk;

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Integer getSubjectFk() {
        return subjectFk;
    }

    public void setSubjectFk(Integer subjectFk) {
        this.subjectFk = subjectFk;
    }

    public Integer getSubjectTypeFk() {
        return subjectTypeFk;
    }

    public void setSubjectTypeFk(Integer subjectTypeFk) {
        this.subjectTypeFk = subjectTypeFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer1 = (Customer) o;

        if (customer != null ? !customer.equals(customer1.customer) : customer1.customer != null) return false;
        if (subjectFk != null ? !subjectFk.equals(customer1.subjectFk) : customer1.subjectFk != null) return false;
        if (subjectTypeFk != null ? !subjectTypeFk.equals(customer1.subjectTypeFk) : customer1.subjectTypeFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customer != null ? customer.hashCode() : 0;
        result = 31 * result + (subjectFk != null ? subjectFk.hashCode() : 0);
        result = 31 * result + (subjectTypeFk != null ? subjectTypeFk.hashCode() : 0);
        return result;
    }
}
