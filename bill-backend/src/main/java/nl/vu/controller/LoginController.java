package nl.vu.controller;

import nl.vu.dto.LoginDTO;
import nl.vu.dto.RegisterDTO;
import nl.vu.result.Result;
import nl.vu.service.AuthenticationService;
import nl.vu.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 三分恶
 * @Date: 2021/1/17
 * @Description: TODO
 **/
@RestController()
public class LoginController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/api/auth/login")
    public ResponseEntity<LoginVO> login(@RequestBody LoginDTO loginDTO){
      return authenticationService.login(loginDTO);
    }

    @PostMapping(value = "/api/auth/register")
    public ResponseEntity<LoginVO> login(@RequestBody RegisterDTO registerDTO){
        return authenticationService.register(registerDTO);
    }

    @PostMapping(value = "/api/hello")
    public Result hello(){
        return new Result(200,"hello","world");
    }
}
