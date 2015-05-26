package t124003.backend.model.document;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DocAttributeType {
    private Integer docAttributeType;
    private Integer defaultSelectionIdFk;
    private String typeName;
    private String defaultValueText;
    private Integer dataTypeFk;
    private String multipleAttributes;

    private List<AtrTypeSelectionValue> selectionValues;

    public Integer getDocAttributeType() {
        return docAttributeType;
    }


    public void setDocAttributeType(Integer docAttributeType) {
        this.docAttributeType = docAttributeType;
    }

    public Integer getDefaultSelectionIdFk() {
        return defaultSelectionIdFk;
    }

    public void setDefaultSelectionIdFk(Integer defaultSelectionIdFk) {
        this.defaultSelectionIdFk = defaultSelectionIdFk;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDefaultValueText() {
        return defaultValueText;
    }

    public void setDefaultValueText(String defaultValueText) {
        this.defaultValueText = defaultValueText;
    }

    public Integer getDataTypeFk() {
        return dataTypeFk;
    }

    public void setDataTypeFk(Integer dataTypeFk) {
        this.dataTypeFk = dataTypeFk;
    }

    public String getMultipleAttributes() {
        return multipleAttributes;
    }

    public void setMultipleAttributes(String multipleAttributes) {
        this.multipleAttributes = multipleAttributes;
    }

    public List<AtrTypeSelectionValue> getSelectionValues() {
        return selectionValues;
    }

    public void setSelectionValues(List<AtrTypeSelectionValue> selectionValues) {
        this.selectionValues = selectionValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocAttributeType that = (DocAttributeType) o;

        if (dataTypeFk != null ? !dataTypeFk.equals(that.dataTypeFk) : that.dataTypeFk != null) return false;
        if (defaultSelectionIdFk != null ? !defaultSelectionIdFk.equals(that.defaultSelectionIdFk) : that.defaultSelectionIdFk != null)
            return false;
        if (defaultValueText != null ? !defaultValueText.equals(that.defaultValueText) : that.defaultValueText != null)
            return false;
        if (docAttributeType != null ? !docAttributeType.equals(that.docAttributeType) : that.docAttributeType != null)
            return false;
        if (multipleAttributes != null ? !multipleAttributes.equals(that.multipleAttributes) : that.multipleAttributes != null)
            return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = docAttributeType != null ? docAttributeType.hashCode() : 0;
        result = 31 * result + (defaultSelectionIdFk != null ? defaultSelectionIdFk.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (defaultValueText != null ? defaultValueText.hashCode() : 0);
        result = 31 * result + (dataTypeFk != null ? dataTypeFk.hashCode() : 0);
        result = 31 * result + (multipleAttributes != null ? multipleAttributes.hashCode() : 0);
        return result;
    }
}
