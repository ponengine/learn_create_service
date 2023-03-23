package th.co.oreopon.authen.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class SignupRequest {

    private String username;

    private String email;

    private Set<String> role;

    private String password;
}
