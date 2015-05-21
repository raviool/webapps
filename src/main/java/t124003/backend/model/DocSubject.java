package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocSubject {
    private Integer docSubject;
    private Integer docSubjectRelationTypeFk;
    private Integer docSubjectTypeFk;
    private Integer documentFk;
    private Integer subjectFk;
    private String note;

    public Integer getDocSubject() {
        return docSubject;
    }

    public void setDocSubject(Integer docSubject) {
        this.docSubject = docSubject;
    }

    public Integer getDocSubjectRelationTypeFk() {
        return docSubjectRelationTypeFk;
    }

    public void setDocSubjectRelationTypeFk(Integer docSubjectRelationTypeFk) {
        this.docSubjectRelationTypeFk = docSubjectRelationTypeFk;
    }

    public Integer getDocSubjectTypeFk() {
        return docSubjectTypeFk;
    }

    public void setDocSubjectTypeFk(Integer docSubjectTypeFk) {
        this.docSubjectTypeFk = docSubjectTypeFk;
    }

    public Integer getDocumentFk() {
        return documentFk;
    }

    public void setDocumentFk(Integer documentFk) {
        this.documentFk = documentFk;
    }

    public Integer getSubjectFk() {
        return subjectFk;
    }

    public void setSubjectFk(Integer subjectFk) {
        this.subjectFk = subjectFk;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocSubject that = (DocSubject) o;

        if (docSubject != null ? !docSubject.equals(that.docSubject) : that.docSubject != null) return false;
        if (docSubjectRelationTypeFk != null ? !docSubjectRelationTypeFk.equals(that.docSubjectRelationTypeFk) : that.docSubjectRelationTypeFk != null)
            return false;
        if (docSubjectTypeFk != null ? !docSubjectTypeFk.equals(that.docSubjectTypeFk) : that.docSubjectTypeFk != null)
            return false;
        if (documentFk != null ? !documentFk.equals(that.documentFk) : that.documentFk != null) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (subjectFk != null ? !subjectFk.equals(that.subjectFk) : that.subjectFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docSubject != null ? docSubject.hashCode() : 0;
        result = 31 * result + (docSubjectRelationTypeFk != null ? docSubjectRelationTypeFk.hashCode() : 0);
        result = 31 * result + (docSubjectTypeFk != null ? docSubjectTypeFk.hashCode() : 0);
        result = 31 * result + (documentFk != null ? documentFk.hashCode() : 0);
        result = 31 * result + (subjectFk != null ? subjectFk.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
