package own.jadezhang.learning.almond.mp.service.user.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import own.jadezhang.learning.almond.mp.domain.AuthUser;
import own.jadezhang.learning.almond.mp.mapper.user.AuthUserMapper;
import own.jadezhang.learning.almond.mp.service.user.IAuthUserService;

/**
 * Created by Zhang Junwei on 2017/9/21 0021.
 */
@Service("AuthUserServiceImpl")
public class AuthUserServiceImpl  extends ServiceImpl<AuthUserMapper, AuthUser> implements IAuthUserService{
}
