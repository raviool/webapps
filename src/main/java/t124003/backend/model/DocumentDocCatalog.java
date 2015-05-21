package t124003.backend.model;

import java.sql.Timestamp;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocumentDocCatalog {
    private Integer documentDocCatalog;
    private Integer documentFk;
    private Integer docCatalogFk;
    private Timestamp catalogTime;

    public Integer getDocumentDocCatalog() {
        return documentDocCatalog;
    }

    public void setDocumentDocCatalog(Integer documentDocCatalog) {
        this.documentDocCatalog = documentDocCatalog;
    }

    public Integer getDocumentFk() {
        return documentFk;
    }

    public void setDocumentFk(Integer documentFk) {
        this.documentFk = documentFk;
    }

    public Integer getDocCatalogFk() {
        return docCatalogFk;
    }

    public void setDocCatalogFk(Integer docCatalogFk) {
        this.docCatalogFk = docCatalogFk;
    }

    public Timestamp getCatalogTime() {
        return catalogTime;
    }

    public void setCatalogTime(Timestamp catalogTime) {
        this.catalogTime = catalogTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentDocCatalog that = (DocumentDocCatalog) o;

        if (catalogTime != null ? !catalogTime.equals(that.catalogTime) : that.catalogTime != null) return false;
        if (docCatalogFk != null ? !docCatalogFk.equals(that.docCatalogFk) : that.docCatalogFk != null) return false;
        if (documentDocCatalog != null ? !documentDocCatalog.equals(that.documentDocCatalog) : that.documentDocCatalog != null)
            return false;
        if (documentFk != null ? !documentFk.equals(that.documentFk) : that.documentFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = documentDocCatalog != null ? documentDocCatalog.hashCode() : 0;
        result = 31 * result + (documentFk != null ? documentFk.hashCode() : 0);
        result = 31 * result + (docCatalogFk != null ? docCatalogFk.hashCode() : 0);
        result = 31 * result + (catalogTime != null ? catalogTime.hashCode() : 0);
        return result;
    }
}
