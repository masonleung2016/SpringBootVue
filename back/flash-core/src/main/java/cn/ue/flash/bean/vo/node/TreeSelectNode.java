package cn.ue.flash.bean.vo.node;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @Description: 配合vue-treeselect使用的节点对象
 * @Author: LCF
 * @Date: 2020/7/20 14:27
 * @Package: cn.ue.flash.bean.vo.node
 * @Version 1.0
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreeSelectNode {
    private String id;
    private String label;
    private List<TreeSelectNode> children;

    public void setId(String code) {

    }

    public void setLabel(String name) {

    }

    public void setChildren(List<TreeSelectNode> children) {

    }
}
