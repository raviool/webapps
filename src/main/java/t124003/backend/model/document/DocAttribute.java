package t124003.backend.model.document;

import java.sql.Date;
import java.util.List;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocAttribute {
    private Integer docAttribute;
    private Integer atrTypeSelectionValueFk;
    private Integer docAttributeTypeFk;
    private Integer documentFk;
    private String typeName;
    private String valueText;
    private Integer valueNumber;
    private Date valueDate;
    private Integer dataType;
    private Integer orderby;
    private String required;
    private List<AtrTypeSelectionValue> selectionValues;

    public Integer getDocAttribute() {
        return docAttribute;
    }

    public void setDocAttribute(Integer docAttribute) {
        this.docAttribute = docAttribute;
    }

    public Integer getAtrTypeSelectionValueFk() {
        return atrTypeSelectionValueFk;
    }

    public void setAtrTypeSelectionValueFk(Integer atrTypeSelectionValueFk) {
        this.atrTypeSelectionValueFk = atrTypeSelectionValueFk;
    }

    public Integer getDocAttributeTypeFk() {
        return docAttributeTypeFk;
    }

    public void setDocAttributeTypeFk(Integer docAttributeTypeFk) {
        this.docAttributeTypeFk = docAttributeTypeFk;
    }

    public Integer getDocumentFk() {
        return documentFk;
    }

    public void setDocumentFk(Integer documentFk) {
        this.documentFk = documentFk;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    public Integer getValueNumber() {
        return valueNumber;
    }

    public void setValueNumber(Integer valueNumber) {
        this.valueNumber = valueNumber;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
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

    public void setSelectionValues(List<AtrTypeSelectionValue> values) {
        this.selectionValues = values;
    }

    public List<AtrTypeSelectionValue> getSelectionValues() {
        return selectionValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocAttribute that = (DocAttribute) o;

        if (atrTypeSelectionValueFk != null ? !atrTypeSelectionValueFk.equals(that.atrTypeSelectionValueFk) : that.atrTypeSelectionValueFk != null)
            return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (docAttribute != null ? !docAttribute.equals(that.docAttribute) : that.docAttribute != null) return false;
        if (docAttributeTypeFk != null ? !docAttributeTypeFk.equals(that.docAttributeTypeFk) : that.docAttributeTypeFk != null)
            return false;
        if (documentFk != null ? !documentFk.equals(that.documentFk) : that.documentFk != null) return false;
        if (orderby != null ? !orderby.equals(that.orderby) : that.orderby != null) return false;
        if (required != null ? !required.equals(that.required) : that.required != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
        if (valueDate != null ? !valueDate.equals(that.valueDate) : that.valueDate != null) return false;
        if (valueNumber != null ? !valueNumber.equals(that.valueNumber) : that.valueNumber != null) return false;
        if (valueText != null ? !valueText.equals(that.valueText) : that.valueText != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = docAttribute != null ? docAttribute.hashCode() : 0;
        result = 31 * result + (atrTypeSelectionValueFk != null ? atrTypeSelectionValueFk.hashCode() : 0);
        result = 31 * result + (docAttributeTypeFk != null ? docAttributeTypeFk.hashCode() : 0);
        result = 31 * result + (documentFk != null ? documentFk.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (valueText != null ? valueText.hashCode() : 0);
        result = 31 * result + (valueNumber != null ? valueNumber.hashCode() : 0);
        result = 31 * result + (valueDate != null ? valueDate.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (orderby != null ? orderby.hashCode() : 0);
        result = 31 * result + (required != null ? required.hashCode() : 0);
        return result;
    }
}
