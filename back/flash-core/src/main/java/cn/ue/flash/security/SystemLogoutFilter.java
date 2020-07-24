package cn.ue.flash.security;

import cn.ue.flash.bean.vo.front.Rets;
import cn.ue.flash.utils.JsonUtil;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:00
 * @Package: cn.ue.flash.security
 * @Version 1.0
 */

public class SystemLogoutFilter extends LogoutFilter {
    private static final Logger logger = LoggerFactory.getLogger(SystemLogoutFilter.class);

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        try {
            subject.logout();
        } catch (Exception ex) {
            logger.error("退出登录错误", ex);
        }

        this.writeResult(response);
        /**不执行后续的过滤器*/
        return false;
    }

    private void writeResult(ServletResponse response) {
        /**响应Json结果*/
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(JsonUtil.toJson(Rets.success()));
        } catch (IOException e) {
            logger.error("返回Response信息出现IOException异常:" + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
