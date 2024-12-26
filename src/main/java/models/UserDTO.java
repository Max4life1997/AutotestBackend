package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import models.subdata.AddressDTO;
import models.subdata.CompanyDTO;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    public int id;
    public String name;
    public String username;
    public String email;
    public AddressDTO address;
    public String phone;
    public String website;
    public CompanyDTO company;
}
