package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class EmployeeRoleType {
    private Integer employeeRoleType;
    private String typeName;

    public Integer getEmployeeRoleType() {
        return employeeRoleType;
    }

    public void setEmployeeRoleType(Integer employeeRoleType) {
        this.employeeRoleType = employeeRoleType;
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

        EmployeeRoleType that = (EmployeeRoleType) o;

        if (employeeRoleType != null ? !employeeRoleType.equals(that.employeeRoleType) : that.employeeRoleType != null)
            return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeRoleType != null ? employeeRoleType.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
