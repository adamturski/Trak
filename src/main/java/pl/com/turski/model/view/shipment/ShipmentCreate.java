package pl.com.turski.model.view.shipment;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * User: Adam
 */
public class ShipmentCreate implements Serializable {

    private String senderCompany;
    @NotBlank
    private String senderName;
    @NotBlank
    private String senderSurname;
    private String senderPhone;
    @NotBlank
    private String senderStreet;
    @NotBlank
    private String senderHouse;
    private String senderFlat;
    @NotBlank
    private String senderPostcode;
    @NotBlank
    private String senderCity;
    private String senderState;
    @NotBlank
    private String senderCountry;
    private String recipientCompany;
    @NotBlank
    private String recipientName;
    @NotBlank
    private String recipientSurname;
    private String recipientPhone;
    @NotBlank
    private String recipientStreet;
    @NotBlank
    private String recipientHouse;
    private String recipientFlat;
    @NotBlank
    private String recipientPostcode;
    @NotBlank
    private String recipientCity;
    private String recipientState;
    @NotBlank
    private String recipientCountry;

    public ShipmentCreate() {
    }

    public String getSenderCompany() {
        return senderCompany;
    }

    public void setSenderCompany(String senderCompany) {
        this.senderCompany = senderCompany;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderSurname() {
        return senderSurname;
    }

    public void setSenderSurname(String senderSurname) {
        this.senderSurname = senderSurname;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderStreet() {
        return senderStreet;
    }

    public void setSenderStreet(String senderStreet) {
        this.senderStreet = senderStreet;
    }

    public String getSenderHouse() {
        return senderHouse;
    }

    public void setSenderHouse(String senderHouse) {
        this.senderHouse = senderHouse;
    }

    public String getSenderFlat() {
        return senderFlat;
    }

    public void setSenderFlat(String senderFlat) {
        this.senderFlat = senderFlat;
    }

    public String getSenderPostcode() {
        return senderPostcode;
    }

    public void setSenderPostcode(String senderPostcode) {
        this.senderPostcode = senderPostcode;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getSenderState() {
        return senderState;
    }

    public void setSenderState(String senderState) {
        this.senderState = senderState;
    }

    public String getSenderCountry() {
        return senderCountry;
    }

    public void setSenderCountry(String senderCountry) {
        this.senderCountry = senderCountry;
    }

    public String getRecipientCompany() {
        return recipientCompany;
    }

    public void setRecipientCompany(String recipientCompany) {
        this.recipientCompany = recipientCompany;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientSurname() {
        return recipientSurname;
    }

    public void setRecipientSurname(String recipientSurname) {
        this.recipientSurname = recipientSurname;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientStreet() {
        return recipientStreet;
    }

    public void setRecipientStreet(String recipientStreet) {
        this.recipientStreet = recipientStreet;
    }

    public String getRecipientHouse() {
        return recipientHouse;
    }

    public void setRecipientHouse(String recipientHouse) {
        this.recipientHouse = recipientHouse;
    }

    public String getRecipientFlat() {
        return recipientFlat;
    }

    public void setRecipientFlat(String recipientFlat) {
        this.recipientFlat = recipientFlat;
    }

    public String getRecipientPostcode() {
        return recipientPostcode;
    }

    public void setRecipientPostcode(String recipientPostcode) {
        this.recipientPostcode = recipientPostcode;
    }

    public String getRecipientCity() {
        return recipientCity;
    }

    public void setRecipientCity(String recipientCity) {
        this.recipientCity = recipientCity;
    }

    public String getRecipientState() {
        return recipientState;
    }

    public void setRecipientState(String recipientState) {
        this.recipientState = recipientState;
    }

    public String getRecipientCountry() {
        return recipientCountry;
    }

    public void setRecipientCountry(String recipientCountry) {
        this.recipientCountry = recipientCountry;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ShipmentCreate{");
        sb.append("senderCompany='").append(senderCompany).append('\'');
        sb.append(", senderName='").append(senderName).append('\'');
        sb.append(", senderSurname='").append(senderSurname).append('\'');
        sb.append(", senderPhone='").append(senderPhone).append('\'');
        sb.append(", senderStreet='").append(senderStreet).append('\'');
        sb.append(", senderHouse='").append(senderHouse).append('\'');
        sb.append(", senderFlat='").append(senderFlat).append('\'');
        sb.append(", senderPostcode='").append(senderPostcode).append('\'');
        sb.append(", senderCity='").append(senderCity).append('\'');
        sb.append(", senderState='").append(senderState).append('\'');
        sb.append(", senderCountry='").append(senderCountry).append('\'');
        sb.append(", recipientCompany='").append(recipientCompany).append('\'');
        sb.append(", recipientName='").append(recipientName).append('\'');
        sb.append(", recipientSurname='").append(recipientSurname).append('\'');
        sb.append(", recipientPhone='").append(recipientPhone).append('\'');
        sb.append(", recipientStreet='").append(recipientStreet).append('\'');
        sb.append(", recipientHouse='").append(recipientHouse).append('\'');
        sb.append(", recipientFlat='").append(recipientFlat).append('\'');
        sb.append(", recipientPostcode='").append(recipientPostcode).append('\'');
        sb.append(", recipientCity='").append(recipientCity).append('\'');
        sb.append(", recipientState='").append(recipientState).append('\'');
        sb.append(", recipientCountry='").append(recipientCountry).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
