package cn.ue.flash.utils.cache.exception;

import cn.ue.flash.utils.StringUtil;

/**
 * @Description: 工具类初始化异常
 * @Author: LCF
 * @Date: 2020/7/20 15:30
 * @Package: cn.ue.flash.utils.cache.exception
 * @Version 1.0
 */

public class ToolBoxException extends RuntimeException {
    private static final long serialVersionUID = 8247610319171014183L;

    public ToolBoxException(Throwable e) {
        super(e.getMessage(), e);
    }

    public ToolBoxException(String message) {
        super(message);
    }

    public ToolBoxException(String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params));
    }

    public ToolBoxException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ToolBoxException(Throwable throwable, String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params), throwable);
    }
}
