package nl.vu.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.vu.entity.User;

import java.io.Serializable;

/**
 * Login Response
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {
    private Integer id;
    private String token;

    private UserVO user;
}
