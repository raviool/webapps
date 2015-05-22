package t124003.backend.model.document;

import java.sql.Timestamp;

/**
 * Created by Raviool on 21.05.2015.
 */
public class Document {
    private Integer document;
    private String docNr;
    private String name;
    private String description;
    private Timestamp created;
    private Integer createdBy;
    private Timestamp updated;
    private Integer updatedBy;
    private Integer docStatusTypeFk;
    private String filename;

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public String getDocNr() {
        return docNr;
    }

    public void setDocNr(String docNr) {
        this.docNr = docNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getDocStatusTypeFk() {
        return docStatusTypeFk;
    }

    public void setDocStatusTypeFk(Integer docStatusTypeFk) {
        this.docStatusTypeFk = docStatusTypeFk;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document1 = (Document) o;

        if (created != null ? !created.equals(document1.created) : document1.created != null) return false;
        if (createdBy != null ? !createdBy.equals(document1.createdBy) : document1.createdBy != null) return false;
        if (description != null ? !description.equals(document1.description) : document1.description != null)
            return false;
        if (docNr != null ? !docNr.equals(document1.docNr) : document1.docNr != null) return false;
        if (docStatusTypeFk != null ? !docStatusTypeFk.equals(document1.docStatusTypeFk) : document1.docStatusTypeFk != null)
            return false;
        if (document != null ? !document.equals(document1.document) : document1.document != null) return false;
        if (filename != null ? !filename.equals(document1.filename) : document1.filename != null) return false;
        if (name != null ? !name.equals(document1.name) : document1.name != null) return false;
        if (updated != null ? !updated.equals(document1.updated) : document1.updated != null) return false;
        if (updatedBy != null ? !updatedBy.equals(document1.updatedBy) : document1.updatedBy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = document != null ? document.hashCode() : 0;
        result = 31 * result + (docNr != null ? docNr.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (updatedBy != null ? updatedBy.hashCode() : 0);
        result = 31 * result + (docStatusTypeFk != null ? docStatusTypeFk.hashCode() : 0);
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        return result;
    }
}
