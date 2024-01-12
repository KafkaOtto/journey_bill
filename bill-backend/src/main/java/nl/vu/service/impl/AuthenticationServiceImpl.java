package nl.vu.service.impl;

import lombok.RequiredArgsConstructor;
import nl.vu.dto.LoginDTO;
import nl.vu.dto.RegisterDTO;
import nl.vu.entity.Role;
import nl.vu.entity.User;
import nl.vu.mapper.UserMapper;
import nl.vu.result.Result;
import nl.vu.service.AuthenticationService;
import nl.vu.service.TokenService;
import nl.vu.vo.LoginVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import nl.vu.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Login/Register Service
 */
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public ResponseEntity<LoginVO> login(LoginDTO request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("email", request.getEmail());
        User user = userMapper.selectOne(wrapper);

        if (user == null) {
            throw new IllegalArgumentException("Invalid email or password.");
        }

        UserVO userVO = UserVO.builder().firstName(user.getFirstName()).lastName(user.getLastName()).email(user.getEmail())
                .build();
        //login success, add token
        var jwt = tokenService.generateToken(user);
        LoginVO loginVO = LoginVO.builder().id(user.getId()).token(jwt).user(userVO).build();
        return ResponseEntity.ok(loginVO);
    }

    @Override
    public ResponseEntity<LoginVO> register(RegisterDTO request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userMapper.insert(user);
        var jwt = tokenService.generateToken(user);
        LoginVO loginVO = LoginVO.builder().token(jwt).build();
        return ResponseEntity.ok(loginVO);
    }
}
