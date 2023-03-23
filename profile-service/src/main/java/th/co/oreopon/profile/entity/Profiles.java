package th.co.oreopon.profile.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Profiles {
    @Id
    private String profileId;
    private String firstName;
    private String lastName;
    private String email;
    private String job;
    private String status;
    private Date createDate;
}
