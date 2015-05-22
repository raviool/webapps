package t124003.backend.model.document;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocStatusType {
    private Integer docStatusType;
    private String typeName;

    public Integer getDocStatusType() {
        return docStatusType;
    }

    public void setDocStatusType(Integer docStatusType) {
        this.docStatusType = docStatusType;
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

        DocStatusType that = (DocStatusType) o;

        if (docStatusType != null ? !docStatusType.equals(that.docStatusType) : that.docStatusType != null)
            return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docStatusType != null ? docStatusType.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
