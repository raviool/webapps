package t124003.backend.model.document;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocType {
    private Integer docType;
    private Integer superTypeFk;
    private Integer level;
    private String typeName;

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public Integer getSuperTypeFk() {
        return superTypeFk;
    }

    public void setSuperTypeFk(Integer superTypeFk) {
        this.superTypeFk = superTypeFk;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

        DocType docType1 = (DocType) o;

        if (docType != null ? !docType.equals(docType1.docType) : docType1.docType != null) return false;
        if (level != null ? !level.equals(docType1.level) : docType1.level != null) return false;
        if (superTypeFk != null ? !superTypeFk.equals(docType1.superTypeFk) : docType1.superTypeFk != null)
            return false;
        if (typeName != null ? !typeName.equals(docType1.typeName) : docType1.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docType != null ? docType.hashCode() : 0;
        result = 31 * result + (superTypeFk != null ? superTypeFk.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
