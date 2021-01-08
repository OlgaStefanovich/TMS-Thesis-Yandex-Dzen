package by.dzen.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserAuthDTO {

    @NotBlank
    @NotEmpty
    private String loginAuthUser;
    @NotBlank
    @NotEmpty
    private String passwordAuthUser;

    public UserAuthDTO( String loginAuthUser,  String passwordAuthUser) {
        this.loginAuthUser = loginAuthUser;
        this.passwordAuthUser = passwordAuthUser;
    }

    public UserAuthDTO() {
    }

    public String getLoginAuthUser() {
        return loginAuthUser;
    }

    public void setLoginAuthUser(String loginAuthUser) {
        this.loginAuthUser = loginAuthUser;
    }

    public String getPasswordAuthUser() {
        return passwordAuthUser;
    }

    public void setPasswordAuthUser(String passwordAuthUser) {
        this.passwordAuthUser = passwordAuthUser;
    }
}
