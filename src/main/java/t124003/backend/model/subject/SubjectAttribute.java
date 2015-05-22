package t124003.backend.model.subject;

import java.math.BigInteger;
import java.sql.Date;

/**
 * Created by Raviool on 21.05.2015.
 */
public class SubjectAttribute {
    private Integer subjectAttribute;
    private Integer subjectFk;
    private Integer subjectAttributeTypeFk;
    private Integer subjectTypeFk;
    private Integer orderby;
    private String valueText;
    private BigInteger valueNumber;
    private Date valueDate;
    private BigInteger dataType;

    public Integer getSubjectAttribute() {
        return subjectAttribute;
    }

    public void setSubjectAttribute(Integer subjectAttribute) {
        this.subjectAttribute = subjectAttribute;
    }

    public Integer getSubjectFk() {
        return subjectFk;
    }

    public void setSubjectFk(Integer subjectFk) {
        this.subjectFk = subjectFk;
    }

    public Integer getSubjectAttributeTypeFk() {
        return subjectAttributeTypeFk;
    }

    public void setSubjectAttributeTypeFk(Integer subjectAttributeTypeFk) {
        this.subjectAttributeTypeFk = subjectAttributeTypeFk;
    }

    public Integer getSubjectTypeFk() {
        return subjectTypeFk;
    }

    public void setSubjectTypeFk(Integer subjectTypeFk) {
        this.subjectTypeFk = subjectTypeFk;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    public BigInteger getValueNumber() {
        return valueNumber;
    }

    public void setValueNumber(BigInteger valueNumber) {
        this.valueNumber = valueNumber;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public BigInteger getDataType() {
        return dataType;
    }

    public void setDataType(BigInteger dataType) {
        this.dataType = dataType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectAttribute that = (SubjectAttribute) o;

        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (orderby != null ? !orderby.equals(that.orderby) : that.orderby != null) return false;
        if (subjectAttribute != null ? !subjectAttribute.equals(that.subjectAttribute) : that.subjectAttribute != null)
            return false;
        if (subjectAttributeTypeFk != null ? !subjectAttributeTypeFk.equals(that.subjectAttributeTypeFk) : that.subjectAttributeTypeFk != null)
            return false;
        if (subjectFk != null ? !subjectFk.equals(that.subjectFk) : that.subjectFk != null) return false;
        if (subjectTypeFk != null ? !subjectTypeFk.equals(that.subjectTypeFk) : that.subjectTypeFk != null)
            return false;
        if (valueDate != null ? !valueDate.equals(that.valueDate) : that.valueDate != null) return false;
        if (valueNumber != null ? !valueNumber.equals(that.valueNumber) : that.valueNumber != null) return false;
        if (valueText != null ? !valueText.equals(that.valueText) : that.valueText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subjectAttribute != null ? subjectAttribute.hashCode() : 0;
        result = 31 * result + (subjectFk != null ? subjectFk.hashCode() : 0);
        result = 31 * result + (subjectAttributeTypeFk != null ? subjectAttributeTypeFk.hashCode() : 0);
        result = 31 * result + (subjectTypeFk != null ? subjectTypeFk.hashCode() : 0);
        result = 31 * result + (orderby != null ? orderby.hashCode() : 0);
        result = 31 * result + (valueText != null ? valueText.hashCode() : 0);
        result = 31 * result + (valueNumber != null ? valueNumber.hashCode() : 0);
        result = 31 * result + (valueDate != null ? valueDate.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        return result;
    }
}
