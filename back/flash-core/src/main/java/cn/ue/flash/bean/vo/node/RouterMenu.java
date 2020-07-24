package cn.ue.flash.bean.vo.node;

import cn.ue.flash.utils.Lists;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:27
 * @Package: cn.ue.flash.bean.vo.node
 * @Version 1.0
 */

@Data
public class RouterMenu {
    private Long id;
    private Long parentId;
    private String path;
    private String component;
    private String name;
    private Integer num;
    private Boolean hidden = false;
    private MenuMeta meta;
    private List<RouterMenu> children = Lists.newArrayList();

    public List<RouterMenu> getChildren() {
        return children;
    }

    public Number getParentId() {
        return null;
    }

    public void setParentId(Long valueOf) {

    }

    public void setPath(String valueOf) {

    }

    public void setName(String valueOf) {

    }

    public void setComponent(String toString) {

    }

    public void setId(Long valueOf) {

    }

    public void setMeta(MenuMeta meta) {

    }

    public void setHidden(boolean b) {

    }

    public int getNum() {
        return 0;
    }

    public void setNum(Integer valueOf) {

    }
}
