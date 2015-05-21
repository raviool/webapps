package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocTypeAttribute {
    private Integer docTypeAttribute;
    private Integer docAttributeTypeFk;
    private Integer docTypeFk;
    private Integer orderby;
    private String required;
    private String createdByDefault;

    public Integer getDocTypeAttribute() {
        return docTypeAttribute;
    }

    public void setDocTypeAttribute(Integer docTypeAttribute) {
        this.docTypeAttribute = docTypeAttribute;
    }

    public Integer getDocAttributeTypeFk() {
        return docAttributeTypeFk;
    }

    public void setDocAttributeTypeFk(Integer docAttributeTypeFk) {
        this.docAttributeTypeFk = docAttributeTypeFk;
    }

    public Integer getDocTypeFk() {
        return docTypeFk;
    }

    public void setDocTypeFk(Integer docTypeFk) {
        this.docTypeFk = docTypeFk;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getCreatedByDefault() {
        return createdByDefault;
    }

    public void setCreatedByDefault(String createdByDefault) {
        this.createdByDefault = createdByDefault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocTypeAttribute that = (DocTypeAttribute) o;

        if (createdByDefault != null ? !createdByDefault.equals(that.createdByDefault) : that.createdByDefault != null)
            return false;
        if (docAttributeTypeFk != null ? !docAttributeTypeFk.equals(that.docAttributeTypeFk) : that.docAttributeTypeFk != null)
            return false;
        if (docTypeAttribute != null ? !docTypeAttribute.equals(that.docTypeAttribute) : that.docTypeAttribute != null)
            return false;
        if (docTypeFk != null ? !docTypeFk.equals(that.docTypeFk) : that.docTypeFk != null) return false;
        if (orderby != null ? !orderby.equals(that.orderby) : that.orderby != null) return false;
        if (required != null ? !required.equals(that.required) : that.required != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docTypeAttribute != null ? docTypeAttribute.hashCode() : 0;
        result = 31 * result + (docAttributeTypeFk != null ? docAttributeTypeFk.hashCode() : 0);
        result = 31 * result + (docTypeFk != null ? docTypeFk.hashCode() : 0);
        result = 31 * result + (orderby != null ? orderby.hashCode() : 0);
        result = 31 * result + (required != null ? required.hashCode() : 0);
        result = 31 * result + (createdByDefault != null ? createdByDefault.hashCode() : 0);
        return result;
    }
}
