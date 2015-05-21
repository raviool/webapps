package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class StructUnit {
    private Integer structUnit;
    private Integer enterpriseFk;
    private Integer upperUnitFk;
    private Integer level;
    private String name;

    public Integer getStructUnit() {
        return structUnit;
    }

    public void setStructUnit(Integer structUnit) {
        this.structUnit = structUnit;
    }

    public Integer getEnterpriseFk() {
        return enterpriseFk;
    }

    public void setEnterpriseFk(Integer enterpriseFk) {
        this.enterpriseFk = enterpriseFk;
    }

    public Integer getUpperUnitFk() {
        return upperUnitFk;
    }

    public void setUpperUnitFk(Integer upperUnitFk) {
        this.upperUnitFk = upperUnitFk;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StructUnit that = (StructUnit) o;

        if (enterpriseFk != null ? !enterpriseFk.equals(that.enterpriseFk) : that.enterpriseFk != null) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (structUnit != null ? !structUnit.equals(that.structUnit) : that.structUnit != null) return false;
        if (upperUnitFk != null ? !upperUnitFk.equals(that.upperUnitFk) : that.upperUnitFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = structUnit != null ? structUnit.hashCode() : 0;
        result = 31 * result + (enterpriseFk != null ? enterpriseFk.hashCode() : 0);
        result = 31 * result + (upperUnitFk != null ? upperUnitFk.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
