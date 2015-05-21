package t124003.backend.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Raviool on 21.05.2015.
 */
public class UserAccount {
    private Integer userAccount;
    private Integer subjectTypeFk;
    private Integer subjectFk;
    private String username;
    private String passw;
    private Integer status;
    private Date validFrom;
    private Date validTo;
    private Integer createdBy;
    private Timestamp created;
    private String passwordNeverExpires;

    public Integer getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Integer userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getSubjectTypeFk() {
        return subjectTypeFk;
    }

    public void setSubjectTypeFk(Integer subjectTypeFk) {
        this.subjectTypeFk = subjectTypeFk;
    }

    public Integer getSubjectFk() {
        return subjectFk;
    }

    public void setSubjectFk(Integer subjectFk) {
        this.subjectFk = subjectFk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getPasswordNeverExpires() {
        return passwordNeverExpires;
    }

    public void setPasswordNeverExpires(String passwordNeverExpires) {
        this.passwordNeverExpires = passwordNeverExpires;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccount that = (UserAccount) o;

        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (createdBy != null ? !createdBy.equals(that.createdBy) : that.createdBy != null) return false;
        if (passw != null ? !passw.equals(that.passw) : that.passw != null) return false;
        if (passwordNeverExpires != null ? !passwordNeverExpires.equals(that.passwordNeverExpires) : that.passwordNeverExpires != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (subjectFk != null ? !subjectFk.equals(that.subjectFk) : that.subjectFk != null) return false;
        if (subjectTypeFk != null ? !subjectTypeFk.equals(that.subjectTypeFk) : that.subjectTypeFk != null)
            return false;
        if (userAccount != null ? !userAccount.equals(that.userAccount) : that.userAccount != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (validFrom != null ? !validFrom.equals(that.validFrom) : that.validFrom != null) return false;
        if (validTo != null ? !validTo.equals(that.validTo) : that.validTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userAccount != null ? userAccount.hashCode() : 0;
        result = 31 * result + (subjectTypeFk != null ? subjectTypeFk.hashCode() : 0);
        result = 31 * result + (subjectFk != null ? subjectFk.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (passw != null ? passw.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (validFrom != null ? validFrom.hashCode() : 0);
        result = 31 * result + (validTo != null ? validTo.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (passwordNeverExpires != null ? passwordNeverExpires.hashCode() : 0);
        return result;
    }
}
