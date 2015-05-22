package t124003.backend.model.document;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocumentDocType {
    private Integer documentDocType;
    private Integer docTypeFk;
    private Integer documentFk;

    public Integer getDocumentDocType() {
        return documentDocType;
    }

    public void setDocumentDocType(Integer documentDocType) {
        this.documentDocType = documentDocType;
    }

    public Integer getDocTypeFk() {
        return docTypeFk;
    }

    public void setDocTypeFk(Integer docTypeFk) {
        this.docTypeFk = docTypeFk;
    }

    public Integer getDocumentFk() {
        return documentFk;
    }

    public void setDocumentFk(Integer documentFk) {
        this.documentFk = documentFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentDocType that = (DocumentDocType) o;

        if (docTypeFk != null ? !docTypeFk.equals(that.docTypeFk) : that.docTypeFk != null) return false;
        if (documentDocType != null ? !documentDocType.equals(that.documentDocType) : that.documentDocType != null)
            return false;
        if (documentFk != null ? !documentFk.equals(that.documentFk) : that.documentFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = documentDocType != null ? documentDocType.hashCode() : 0;
        result = 31 * result + (docTypeFk != null ? docTypeFk.hashCode() : 0);
        result = 31 * result + (documentFk != null ? documentFk.hashCode() : 0);
        return result;
    }
}
