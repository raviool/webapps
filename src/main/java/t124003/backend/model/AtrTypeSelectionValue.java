package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class AtrTypeSelectionValue {
    private Integer atrTypeSelectionValue;
    private Integer docAttributeTypeFk;
    private String valueText;
    private Integer orderby;

    public Integer getAtrTypeSelectionValue() {
        return atrTypeSelectionValue;
    }

    public void setAtrTypeSelectionValue(Integer atrTypeSelectionValue) {
        this.atrTypeSelectionValue = atrTypeSelectionValue;
    }

    public Integer getDocAttributeTypeFk() {
        return docAttributeTypeFk;
    }

    public void setDocAttributeTypeFk(Integer docAttributeTypeFk) {
        this.docAttributeTypeFk = docAttributeTypeFk;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtrTypeSelectionValue that = (AtrTypeSelectionValue) o;

        if (atrTypeSelectionValue != null ? !atrTypeSelectionValue.equals(that.atrTypeSelectionValue) : that.atrTypeSelectionValue != null)
            return false;
        if (docAttributeTypeFk != null ? !docAttributeTypeFk.equals(that.docAttributeTypeFk) : that.docAttributeTypeFk != null)
            return false;
        if (orderby != null ? !orderby.equals(that.orderby) : that.orderby != null) return false;
        if (valueText != null ? !valueText.equals(that.valueText) : that.valueText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = atrTypeSelectionValue != null ? atrTypeSelectionValue.hashCode() : 0;
        result = 31 * result + (docAttributeTypeFk != null ? docAttributeTypeFk.hashCode() : 0);
        result = 31 * result + (valueText != null ? valueText.hashCode() : 0);
        result = 31 * result + (orderby != null ? orderby.hashCode() : 0);
        return result;
    }
}
