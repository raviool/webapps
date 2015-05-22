package t124003.backend.model.subject;

/**
 * Created by Raviool on 21.05.2015.
 */
public class Address {
    private Integer address;
    private Integer addressTypeFk;
    private Integer subjectFk;
    private Integer subjectTypeFk;
    private String country;
    private String county;
    private String townVillage;
    private String streetAddress;
    private String zipcode;

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Integer getAddressTypeFk() {
        return addressTypeFk;
    }

    public void setAddressTypeFk(Integer addressTypeFk) {
        this.addressTypeFk = addressTypeFk;
    }

    public Integer getSubjectFk() {
        return subjectFk;
    }

    public void setSubjectFk(Integer subjectFk) {
        this.subjectFk = subjectFk;
    }

    public Integer getSubjectTypeFk() {
        return subjectTypeFk;
    }

    public void setSubjectTypeFk(Integer subjectTypeFk) {
        this.subjectTypeFk = subjectTypeFk;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTownVillage() {
        return townVillage;
    }

    public void setTownVillage(String townVillage) {
        this.townVillage = townVillage;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address1 = (Address) o;

        if (address != null ? !address.equals(address1.address) : address1.address != null) return false;
        if (addressTypeFk != null ? !addressTypeFk.equals(address1.addressTypeFk) : address1.addressTypeFk != null)
            return false;
        if (country != null ? !country.equals(address1.country) : address1.country != null) return false;
        if (county != null ? !county.equals(address1.county) : address1.county != null) return false;
        if (streetAddress != null ? !streetAddress.equals(address1.streetAddress) : address1.streetAddress != null)
            return false;
        if (subjectFk != null ? !subjectFk.equals(address1.subjectFk) : address1.subjectFk != null) return false;
        if (subjectTypeFk != null ? !subjectTypeFk.equals(address1.subjectTypeFk) : address1.subjectTypeFk != null)
            return false;
        if (townVillage != null ? !townVillage.equals(address1.townVillage) : address1.townVillage != null)
            return false;
        if (zipcode != null ? !zipcode.equals(address1.zipcode) : address1.zipcode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (addressTypeFk != null ? addressTypeFk.hashCode() : 0);
        result = 31 * result + (subjectFk != null ? subjectFk.hashCode() : 0);
        result = 31 * result + (subjectTypeFk != null ? subjectTypeFk.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (townVillage != null ? townVillage.hashCode() : 0);
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        return result;
    }
}
