package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class EmployeeRole {
    private Integer employeeRole;
    private Integer employeeFk;
    private Integer employeeRoleTypeFk;
    private String active;

    public Integer getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(Integer employeeRole) {
        this.employeeRole = employeeRole;
    }

    public Integer getEmployeeFk() {
        return employeeFk;
    }

    public void setEmployeeFk(Integer employeeFk) {
        this.employeeFk = employeeFk;
    }

    public Integer getEmployeeRoleTypeFk() {
        return employeeRoleTypeFk;
    }

    public void setEmployeeRoleTypeFk(Integer employeeRoleTypeFk) {
        this.employeeRoleTypeFk = employeeRoleTypeFk;
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

        EmployeeRole that = (EmployeeRole) o;

        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (employeeFk != null ? !employeeFk.equals(that.employeeFk) : that.employeeFk != null) return false;
        if (employeeRole != null ? !employeeRole.equals(that.employeeRole) : that.employeeRole != null) return false;
        if (employeeRoleTypeFk != null ? !employeeRoleTypeFk.equals(that.employeeRoleTypeFk) : that.employeeRoleTypeFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeRole != null ? employeeRole.hashCode() : 0;
        result = 31 * result + (employeeFk != null ? employeeFk.hashCode() : 0);
        result = 31 * result + (employeeRoleTypeFk != null ? employeeRoleTypeFk.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        return result;
    }
}
