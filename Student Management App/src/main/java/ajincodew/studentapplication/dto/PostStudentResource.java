package ajincodew.studentapplication.dto;

import ajincodew.studentapplication.validator.UniqueEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostStudentResource {
    @NotEmpty(message = "First name must not be blank")
    private String firstName;

    @NotEmpty(message = "Last name not be blank")
    private String lastName;

    @Email
    @NotBlank(message = "Email must not be blank")
    @UniqueEmail
    private String email;

    @NotNull
    private int age;

    @NotBlank
    private String majorId;
}