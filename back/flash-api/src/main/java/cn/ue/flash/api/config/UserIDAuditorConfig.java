package cn.ue.flash.api.config;

import cn.ue.flash.security.JwtUtil;
import cn.ue.flash.utils.Constants;
import cn.ue.flash.utils.HttpUtil;
import cn.ue.flash.utils.StringUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @Description: 审计功能配置
 * @Author: LCF
 * @Date: 2020/7/20 13:23
 * @Package: cn.ue.flash.api.config
 * @Version 1.0
 */

@Configuration
public class UserIDAuditorConfig implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        try {
            String token = HttpUtil.getRequest().getHeader("Authorization");
            if (StringUtil.isNotEmpty(token)) {
                return Optional.of(JwtUtil.getUserId(token));
            }
        } catch (Exception e) {
            /**返回系统用户id*/
            return Optional.of(Constants.SYSTEM_USER_ID);
        }
        /**返回系统用户id*/
        return Optional.of(Constants.SYSTEM_USER_ID);
    }
}
