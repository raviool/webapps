package t124003.backend.model;

/**
 * Created by Raviool on 21.05.2015.
 */
public class EnterprisePersonRelation {
    private Integer enterprisePersonRelation;
    private Integer personFk;
    private Integer enterpriseFk;
    private Integer entPerRelationTypeFk;

    public Integer getEnterprisePersonRelation() {
        return enterprisePersonRelation;
    }

    public void setEnterprisePersonRelation(Integer enterprisePersonRelation) {
        this.enterprisePersonRelation = enterprisePersonRelation;
    }

    public Integer getPersonFk() {
        return personFk;
    }

    public void setPersonFk(Integer personFk) {
        this.personFk = personFk;
    }

    public Integer getEnterpriseFk() {
        return enterpriseFk;
    }

    public void setEnterpriseFk(Integer enterpriseFk) {
        this.enterpriseFk = enterpriseFk;
    }

    public Integer getEntPerRelationTypeFk() {
        return entPerRelationTypeFk;
    }

    public void setEntPerRelationTypeFk(Integer entPerRelationTypeFk) {
        this.entPerRelationTypeFk = entPerRelationTypeFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnterprisePersonRelation that = (EnterprisePersonRelation) o;

        if (entPerRelationTypeFk != null ? !entPerRelationTypeFk.equals(that.entPerRelationTypeFk) : that.entPerRelationTypeFk != null)
            return false;
        if (enterpriseFk != null ? !enterpriseFk.equals(that.enterpriseFk) : that.enterpriseFk != null) return false;
        if (enterprisePersonRelation != null ? !enterprisePersonRelation.equals(that.enterprisePersonRelation) : that.enterprisePersonRelation != null)
            return false;
        if (personFk != null ? !personFk.equals(that.personFk) : that.personFk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = enterprisePersonRelation != null ? enterprisePersonRelation.hashCode() : 0;
        result = 31 * result + (personFk != null ? personFk.hashCode() : 0);
        result = 31 * result + (enterpriseFk != null ? enterpriseFk.hashCode() : 0);
        result = 31 * result + (entPerRelationTypeFk != null ? entPerRelationTypeFk.hashCode() : 0);
        return result;
    }
}
