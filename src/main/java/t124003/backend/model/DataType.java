package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class DataType {
    private Integer dataType;
    private String typeName;

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataType dataType1 = (DataType) o;

        if (dataType != null ? !dataType.equals(dataType1.dataType) : dataType1.dataType != null) return false;
        if (typeName != null ? !typeName.equals(dataType1.typeName) : dataType1.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dataType != null ? dataType.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
