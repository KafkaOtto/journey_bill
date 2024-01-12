package nl.vu.service;

import nl.vu.dto.LoginDTO;
import nl.vu.dto.RegisterDTO;
import nl.vu.result.Result;
import nl.vu.vo.LoginVO;
import org.springframework.http.ResponseEntity;

/**
 * @Author: 三分恶
 * @Date: 2021/1/17
 * @Description:
 **/

public interface AuthenticationService {
    public ResponseEntity<LoginVO> login(LoginDTO request);

    public ResponseEntity<LoginVO> register(RegisterDTO request);
}
