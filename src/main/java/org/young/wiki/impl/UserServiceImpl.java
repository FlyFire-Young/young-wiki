package org.young.wiki.impl;

import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import org.young.wiki.entity.User;
import org.young.wiki.service.UserService;
import org.young.wiki.utils.ServiceUtil;

/**
 * User: Young
 * Date: 2018/7/24 0024
 * Time: 18:51
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class UserServiceImpl extends AbstractService implements UserService {

    @Override
    public void createUser(String username, String password, String phone, String email) {
        User user = userDao.getByUsername(username);
        if (null != user) {
            return;
        }
        user = new User();
        user.setEmail(email);
        user.setName(username);
        user.setPhone(phone);
        user.setPassword(ServiceUtil.md5(password));
        userDao.save(user);
    }

    @Override
    public boolean checkUser(String username) {
        if (StringUtils.isEmpty(username)) {
            return false;
        }
        return userDao.existUserName(username);
    }

    @Override
    public User getById(Long id) {
        return userDao.get(id);
    }

    @Override
    public boolean deleteById(Long id) {
        User user = userDao.get(id);
        if (null != user) {
            userDao.delete(user);
            return true;
        }
        return false;
    }
}
