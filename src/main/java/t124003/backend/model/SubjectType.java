package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class SubjectType {
    private Integer subjectType;
    private String typeName;

    public Integer getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Integer subjectType) {
        this.subjectType = subjectType;
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

        SubjectType that = (SubjectType) o;

        if (subjectType != null ? !subjectType.equals(that.subjectType) : that.subjectType != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subjectType != null ? subjectType.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
