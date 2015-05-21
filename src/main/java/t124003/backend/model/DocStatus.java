package t124003.backend.model;

import java.sql.Timestamp;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocStatus {
    private Integer docStatus;
    private Integer documentFk;
    private Integer docStatusTypeFk;
    private Timestamp statusBegin;
    private Timestamp statusEnd;
    private Integer createdBy;

    public Integer getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(Integer docStatus) {
        this.docStatus = docStatus;
    }

    public Integer getDocumentFk() {
        return documentFk;
    }

    public void setDocumentFk(Integer documentFk) {
        this.documentFk = documentFk;
    }

    public Integer getDocStatusTypeFk() {
        return docStatusTypeFk;
    }

    public void setDocStatusTypeFk(Integer docStatusTypeFk) {
        this.docStatusTypeFk = docStatusTypeFk;
    }

    public Timestamp getStatusBegin() {
        return statusBegin;
    }

    public void setStatusBegin(Timestamp statusBegin) {
        this.statusBegin = statusBegin;
    }

    public Timestamp getStatusEnd() {
        return statusEnd;
    }

    public void setStatusEnd(Timestamp statusEnd) {
        this.statusEnd = statusEnd;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocStatus docStatus1 = (DocStatus) o;

        if (createdBy != null ? !createdBy.equals(docStatus1.createdBy) : docStatus1.createdBy != null) return false;
        if (docStatus != null ? !docStatus.equals(docStatus1.docStatus) : docStatus1.docStatus != null) return false;
        if (docStatusTypeFk != null ? !docStatusTypeFk.equals(docStatus1.docStatusTypeFk) : docStatus1.docStatusTypeFk != null)
            return false;
        if (documentFk != null ? !documentFk.equals(docStatus1.documentFk) : docStatus1.documentFk != null)
            return false;
        if (statusBegin != null ? !statusBegin.equals(docStatus1.statusBegin) : docStatus1.statusBegin != null)
            return false;
        if (statusEnd != null ? !statusEnd.equals(docStatus1.statusEnd) : docStatus1.statusEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docStatus != null ? docStatus.hashCode() : 0;
        result = 31 * result + (documentFk != null ? documentFk.hashCode() : 0);
        result = 31 * result + (docStatusTypeFk != null ? docStatusTypeFk.hashCode() : 0);
        result = 31 * result + (statusBegin != null ? statusBegin.hashCode() : 0);
        result = 31 * result + (statusEnd != null ? statusEnd.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        return result;
    }
}
