package t124003.backend.model.subject;

/**
 * Created by Raviool on 21.05.2015.
 */
public class Employee {
    private Integer employee;
    private Integer personFk;
    private Integer enterpriseFk;
    private Integer structUnitFk;
    private String active;

    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    public Integer getPersonFk() {
        return personFk;
    }

    public void setPersonFk(Integer personFk) {
        this.personFk = personFk;
    }

    public Integer getEnterpriseFk() {
        return enterpriseFk;
    }

    public void setEnterpriseFk(Integer enterpriseFk) {
        this.enterpriseFk = enterpriseFk;
    }

    public Integer getStructUnitFk() {
        return structUnitFk;
    }

    public void setStructUnitFk(Integer structUnitFk) {
        this.structUnitFk = structUnitFk;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee1 = (Employee) o;

        if (active != null ? !active.equals(employee1.active) : employee1.active != null) return false;
        if (employee != null ? !employee.equals(employee1.employee) : employee1.employee != null) return false;
        if (enterpriseFk != null ? !enterpriseFk.equals(employee1.enterpriseFk) : employee1.enterpriseFk != null)
            return false;
        if (personFk != null ? !personFk.equals(employee1.personFk) : employee1.personFk != null) return false;
        if (structUnitFk != null ? !structUnitFk.equals(employee1.structUnitFk) : employee1.structUnitFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employee != null ? employee.hashCode() : 0;
        result = 31 * result + (personFk != null ? personFk.hashCode() : 0);
        result = 31 * result + (enterpriseFk != null ? enterpriseFk.hashCode() : 0);
        result = 31 * result + (structUnitFk != null ? structUnitFk.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }
}
