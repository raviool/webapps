package t124003.backend.model.subject;

import java.math.BigInteger;

/**
 * Created by Raviool on 21.05.2015.
 */
public class SubjectAttributeType {
    private Integer subjectAttributeType;
    private Integer subjectTypeFk;
    private String typeName;
    private BigInteger dataType;
    private Integer orderby;
    private String required;
    private String multipleAttributes;
    private String createdByDefault;

    public Integer getSubjectAttributeType() {
        return subjectAttributeType;
    }

    public void setSubjectAttributeType(Integer subjectAttributeType) {
        this.subjectAttributeType = subjectAttributeType;
    }

    public Integer getSubjectTypeFk() {
        return subjectTypeFk;
    }

    public void setSubjectTypeFk(Integer subjectTypeFk) {
        this.subjectTypeFk = subjectTypeFk;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigInteger getDataType() {
        return dataType;
    }

    public void setDataType(BigInteger dataType) {
        this.dataType = dataType;
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

    public String getMultipleAttributes() {
        return multipleAttributes;
    }

    public void setMultipleAttributes(String multipleAttributes) {
        this.multipleAttributes = multipleAttributes;
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

        SubjectAttributeType that = (SubjectAttributeType) o;

        if (createdByDefault != null ? !createdByDefault.equals(that.createdByDefault) : that.createdByDefault != null)
            return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (multipleAttributes != null ? !multipleAttributes.equals(that.multipleAttributes) : that.multipleAttributes != null)
            return false;
        if (orderby != null ? !orderby.equals(that.orderby) : that.orderby != null) return false;
        if (required != null ? !required.equals(that.required) : that.required != null) return false;
        if (subjectAttributeType != null ? !subjectAttributeType.equals(that.subjectAttributeType) : that.subjectAttributeType != null)
            return false;
        if (subjectTypeFk != null ? !subjectTypeFk.equals(that.subjectTypeFk) : that.subjectTypeFk != null)
            return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subjectAttributeType != null ? subjectAttributeType.hashCode() : 0;
        result = 31 * result + (subjectTypeFk != null ? subjectTypeFk.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (orderby != null ? orderby.hashCode() : 0);
        result = 31 * result + (required != null ? required.hashCode() : 0);
        result = 31 * result + (multipleAttributes != null ? multipleAttributes.hashCode() : 0);
        result = 31 * result + (createdByDefault != null ? createdByDefault.hashCode() : 0);
        return result;
    }
}
