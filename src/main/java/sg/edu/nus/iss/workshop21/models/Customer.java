package sg.edu.nus.iss.workshop21.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String company;
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String jobTitle;
    private String BusinessPhone;
    private String homePhone;
    private String mobilePhone;
    private String faxNumber;
    private String address;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String countryRegion;
    private String webPage;
    private String notes;
    private String attachment;

    public JsonObject toJson() throws JsonProcessingException {
        // ObjectMapper objectMapper = new ObjectMapper();
        // return objectMapper.writeValueAsString(this);
        JsonObject jo = Json.createObjectBuilder()
                .add("id", getId())
                .add("company", this.getCompany())
                .add("last_name", this.getLastName())
                .add("first_name", this.getFirstName())
                .add("email_address", (emailAddress != null) ? emailAddress : "null")
                .add("job_title", jobTitle != null ? jobTitle : "null")
                .add("business_phone", BusinessPhone != null ? BusinessPhone : "null")
                .add("home_phone", homePhone != null ? homePhone : "null")
                .add("mobile_phone", mobilePhone != null ? mobilePhone : "null")
                .add("fax_number", faxNumber != null ? faxNumber : "null")
                .add("address", address != null ? address : "null")
                .add("city", city != null ? city : "null")
                .add("state_province", stateProvince != null ? stateProvince : "null")
                .add("zip_postal_code", zipPostalCode != null ? zipPostalCode : "null")
                .add("country_region", countryRegion != null ? countryRegion : "null")
                .add("web_page", webPage != null ? webPage : "null")
                .add("notes", notes != null ? notes : "null")
                .add("attachment", attachment != null ? attachment : "null")
                .build();

        return jo;
    }
}
