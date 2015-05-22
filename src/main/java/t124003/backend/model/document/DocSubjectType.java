package t124003.backend.model.document;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocSubjectType {
    private Integer docSubjectType;
    private String typeName;

    public Integer getDocSubjectType() {
        return docSubjectType;
    }

    public void setDocSubjectType(Integer docSubjectType) {
        this.docSubjectType = docSubjectType;
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

        DocSubjectType that = (DocSubjectType) o;

        if (docSubjectType != null ? !docSubjectType.equals(that.docSubjectType) : that.docSubjectType != null)
            return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docSubjectType != null ? docSubjectType.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
