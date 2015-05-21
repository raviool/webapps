package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class EntPerRelationType {
    private Integer entPerRelationType;
    private String typeName;

    public Integer getEntPerRelationType() {
        return entPerRelationType;
    }

    public void setEntPerRelationType(Integer entPerRelationType) {
        this.entPerRelationType = entPerRelationType;
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

        EntPerRelationType that = (EntPerRelationType) o;

        if (entPerRelationType != null ? !entPerRelationType.equals(that.entPerRelationType) : that.entPerRelationType != null)
            return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = entPerRelationType != null ? entPerRelationType.hashCode() : 0;
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        return result;
    }
}
