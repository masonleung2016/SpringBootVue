package cn.ue.flash.core.factory;

import cn.ue.flash.bean.dto.UserDto;
import cn.ue.flash.bean.entity.system.User;
import org.springframework.beans.BeanUtils;

/**
 * @Description: 用户创建工厂
 * @Author: LCF
 * @Date: 2020/7/20 14:43
 * @Package: cn.ue.flash.core.factory
 * @Version 1.0
 */

public class UserFactory {

    public static User createUser(UserDto userDto, User user) {
        if (userDto == null) {
            return null;
        } else {
            BeanUtils.copyProperties(userDto, user);
            return user;
        }
    }

    public static User updateUser(UserDto userDto, User user) {
        if (userDto == null) {
            return null;
        } else {
            user.setName(userDto.getName());
            user.setDeptid(userDto.getDeptid());
            user.setSex(userDto.getSex());
            user.setPhone(userDto.getPhone());
            user.setEmail(userDto.getEmail());
            user.setBirthday(userDto.getBirthday());
            if (userDto.getStatus() != 0) {
                user.setStatus(userDto.getStatus());
            }
            return user;
        }
    }
}
