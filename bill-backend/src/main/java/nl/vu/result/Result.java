package nl.vu.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * Response Result
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    //code
    private Integer code;
    //success/error message
    private String message;
    //response data
    private Object data;

    public static Result ok(Object data) {
        return new Result(200, "", data);
    }

    public static Result fail(int code, String message) {
        return new Result(code, message, null);
    }

}
