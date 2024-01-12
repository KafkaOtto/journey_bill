package nl.vu.service;

import nl.vu.dto.QueryDTO;
import nl.vu.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author 三分恶
 * @Date 2021/1/23
 * @Description
 */
public interface UserService {

    UserDetailsService userDetailsService();

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    IPage<User> selectUserPage(QueryDTO queryDTO);

    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);

    void batchDelete(List<Integer> ids);
}
