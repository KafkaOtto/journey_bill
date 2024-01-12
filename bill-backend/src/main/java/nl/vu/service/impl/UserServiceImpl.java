package nl.vu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import nl.vu.dto.QueryDTO;
import nl.vu.entity.User;
import nl.vu.mapper.UserMapper;
import nl.vu.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Author 三分恶
 * @Date 2021/1/23
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * return userDetailService for security
     *
     * @return
     */
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                //find by email
                QueryWrapper<User> wrapper = new QueryWrapper();
                wrapper.eq("email", username);
                User user = userMapper.selectOne(wrapper);
                if (user == null) {
                    throw new UsernameNotFoundException("User not found");
                }
                return user;
            }
        };
    }

    @Override
    public IPage<User> selectUserPage(QueryDTO queryDTO) {
        Page<User> page = new Page<>(queryDTO.getPageNo(), queryDTO.getPageSize());
        return userMapper.selectUserPage(page, queryDTO.getKeyword());
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        userMapper.deleteBatchIds(ids);
    }

}
