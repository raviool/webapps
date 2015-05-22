package t124003.backend.model.document;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocCatalogType {
    private Integer docCatalogType;
    private String typeName;

    public Integer getDocCatalogType() {
        return docCatalogType;
    }

    public void setDocCatalogType(Integer docCatalogType) {
        this.docCatalogType = docCatalogType;
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

        DocCatalogType that = (DocCatalogType) o;

        if (docCatalogType != null ? !docCatalogType.equals(that.docCatalogType) : that.docCatalogType != null)
            return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docCatalogType != null ? docCatalogType.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
