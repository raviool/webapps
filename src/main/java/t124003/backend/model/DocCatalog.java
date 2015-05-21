package t124003.backend.model;

import java.sql.Timestamp;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocCatalog {
    private Integer docCatalog;
    private Integer catalogOwnerFk;
    private Integer docCatalogTypeFk;
    private String name;
    private String description;
    private Integer level;
    private Timestamp contentUpdated;
    private Integer contentUpdatedBy;
    private Integer upperCatalogFk;
    private String folder;

    public Integer getDocCatalog() {
        return docCatalog;
    }

    public void setDocCatalog(Integer docCatalog) {
        this.docCatalog = docCatalog;
    }

    public Integer getCatalogOwnerFk() {
        return catalogOwnerFk;
    }

    public void setCatalogOwnerFk(Integer catalogOwnerFk) {
        this.catalogOwnerFk = catalogOwnerFk;
    }

    public Integer getDocCatalogTypeFk() {
        return docCatalogTypeFk;
    }

    public void setDocCatalogTypeFk(Integer docCatalogTypeFk) {
        this.docCatalogTypeFk = docCatalogTypeFk;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Timestamp getContentUpdated() {
        return contentUpdated;
    }

    public void setContentUpdated(Timestamp contentUpdated) {
        this.contentUpdated = contentUpdated;
    }

    public Integer getContentUpdatedBy() {
        return contentUpdatedBy;
    }

    public void setContentUpdatedBy(Integer contentUpdatedBy) {
        this.contentUpdatedBy = contentUpdatedBy;
    }

    public Integer getUpperCatalogFk() {
        return upperCatalogFk;
    }

    public void setUpperCatalogFk(Integer upperCatalogFk) {
        this.upperCatalogFk = upperCatalogFk;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocCatalog that = (DocCatalog) o;

        if (catalogOwnerFk != null ? !catalogOwnerFk.equals(that.catalogOwnerFk) : that.catalogOwnerFk != null)
            return false;
        if (contentUpdated != null ? !contentUpdated.equals(that.contentUpdated) : that.contentUpdated != null)
            return false;
        if (contentUpdatedBy != null ? !contentUpdatedBy.equals(that.contentUpdatedBy) : that.contentUpdatedBy != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (docCatalog != null ? !docCatalog.equals(that.docCatalog) : that.docCatalog != null) return false;
        if (docCatalogTypeFk != null ? !docCatalogTypeFk.equals(that.docCatalogTypeFk) : that.docCatalogTypeFk != null)
            return false;
        if (folder != null ? !folder.equals(that.folder) : that.folder != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (upperCatalogFk != null ? !upperCatalogFk.equals(that.upperCatalogFk) : that.upperCatalogFk != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docCatalog != null ? docCatalog.hashCode() : 0;
        result = 31 * result + (catalogOwnerFk != null ? catalogOwnerFk.hashCode() : 0);
        result = 31 * result + (docCatalogTypeFk != null ? docCatalogTypeFk.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (contentUpdated != null ? contentUpdated.hashCode() : 0);
        result = 31 * result + (contentUpdatedBy != null ? contentUpdatedBy.hashCode() : 0);
        result = 31 * result + (upperCatalogFk != null ? upperCatalogFk.hashCode() : 0);
        result = 31 * result + (folder != null ? folder.hashCode() : 0);
        return result;
    }
}
