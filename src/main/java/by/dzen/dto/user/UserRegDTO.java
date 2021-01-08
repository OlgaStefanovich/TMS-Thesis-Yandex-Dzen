package by.dzen.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserRegDTO {

    @NotBlank
    @NotEmpty
    private String nameUserDTO;
    @NotBlank
    @NotEmpty
    private String loginUserDTO;
    @NotBlank
    @NotEmpty
    private String passwordUserDTO;

    public UserRegDTO(@NotBlank @NotEmpty String nameUserDTO, @NotBlank @NotEmpty String loginUserDTO, @NotBlank @NotEmpty String passwordUserDTO) {
        this.nameUserDTO = nameUserDTO;
        this.loginUserDTO = loginUserDTO;
        this.passwordUserDTO = passwordUserDTO;
    }

    public UserRegDTO() {
    }

    public String getNameUserDTO() {
        return nameUserDTO;
    }

    public void setNameUserDTO(String nameUserDTO) {
        this.nameUserDTO = nameUserDTO;
    }

    public String getLoginUserDTO() {
        return loginUserDTO;
    }

    public void setLoginUserDTO(String loginUserDTO) {
        this.loginUserDTO = loginUserDTO;
    }

    public String getPasswordUserDTO() {
        return passwordUserDTO;
    }

    public void setPasswordUserDTO(String passwordUserDTO) {
        this.passwordUserDTO = passwordUserDTO;
    }
}
