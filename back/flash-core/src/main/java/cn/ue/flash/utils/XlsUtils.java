package cn.ue.flash.utils;

import java.util.Date;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:51
 * @Package: cn.ue.flash.utils
 * @Version 1.0
 */

public class XlsUtils {
    public String dateFmt(Date date, String fmt) {
        if (date == null) {
            return "";
        }
        return DateUtil.formatDate(date, fmt);
    }
}
