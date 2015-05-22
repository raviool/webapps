package t124003.backend.model.document;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocSubjectRelationType {
    private Integer docSubjectRelationType;
    private String typeName;

    public Integer getDocSubjectRelationType() {
        return docSubjectRelationType;
    }

    public void setDocSubjectRelationType(Integer docSubjectRelationType) {
        this.docSubjectRelationType = docSubjectRelationType;
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

        DocSubjectRelationType that = (DocSubjectRelationType) o;

        if (docSubjectRelationType != null ? !docSubjectRelationType.equals(that.docSubjectRelationType) : that.docSubjectRelationType != null)
            return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docSubjectRelationType != null ? docSubjectRelationType.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
