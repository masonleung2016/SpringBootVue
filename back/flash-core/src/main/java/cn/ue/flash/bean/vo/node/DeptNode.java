package cn.ue.flash.bean.vo.node;

import cn.ue.flash.bean.entity.system.Dept;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:22
 * @Package: cn.ue.flash.bean.vo.node
 * @Version 1.0
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeptNode extends Dept {

    private List<DeptNode> children = null;

    public List<DeptNode> getChildren() {
        return children;
    }

    public void setChildren(List<DeptNode> children) {
        this.children = children;
    }

    public String getLabel() {
        return (String) getSimplename();
    }
}
