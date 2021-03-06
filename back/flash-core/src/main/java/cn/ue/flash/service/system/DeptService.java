package cn.ue.flash.service.system;

import cn.ue.flash.bean.entity.system.Dept;
import cn.ue.flash.bean.vo.node.DeptNode;
import cn.ue.flash.bean.vo.node.ZTreeNode;
import cn.ue.flash.dao.system.DeptRepository;
import cn.ue.flash.service.BaseService;
import cn.ue.flash.utils.Lists;
import com.google.common.base.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 15:10
 * @Package: cn.ue.flash.service.system
 * @Version 1.0
 */

@Service
public class DeptService extends BaseService<Dept, Long, DeptRepository> {
  @Autowired
  private DeptRepository deptRepository;

  public List<ZTreeNode> tree() {
    String sql = "SELECT id, pid AS pId, simplename AS NAME, ( CASE WHEN (pId = 0 OR pId IS NULL) THEN 'true' ELSE 'false' END ) AS open FROM t_sys_dept";
    List nodes = deptRepository.queryObjBySql(sql, ZTreeNode.class);
    return nodes;
  }


  public List<Dept> query(String condition) {
    List<Dept> list = null;
    if (Strings.isNullOrEmpty(condition)) {
      list = deptRepository.findAll();
    } else {
      condition = "%" + condition + "%";
      list = deptRepository.findBySimplenameLikeOrFullnameLike(condition, condition);
    }
    return list;
  }

  public void deleteDept(Long deptId) {
    Dept dept = get(deptId);
    List<Dept> subDepts = deptRepository.findByPidsLike("%[" + dept.getId() + "]%");
    deptRepository.deleteAll(subDepts);
    deptRepository.delete(dept);
  }

  public List<DeptNode> queryAllNode() {
    List<Dept> list = queryAll();
    return generateTree(list);
  }

  public void deptSetPids(Dept dept) {
    if (dept.getPid() == 0 || dept.getPid() == 0) {
      dept.setPid(0L);
      dept.setPids("[0],");
    } else {
      int pid = dept.getPid();
      Dept temp = get((long) pid);
      String pids = "";
      if (temp != null) {
        pids = temp.getPids();
      }
      dept.setPid(pid);
      dept.setPids(pids + "[" + pid + "],");
    }
  }

  private List<DeptNode> generateTree(List<Dept> list) {

    List<DeptNode> nodes = new ArrayList<>(20);
    for (Dept dept : list) {
      DeptNode deptNode = new DeptNode();
      BeanUtils.copyProperties(dept, deptNode);
      nodes.add(deptNode);
    }
    for (DeptNode deptNode : nodes) {
      for (DeptNode child : nodes) {
        if (child.getPid() == deptNode.getId().intValue()) {
          List<DeptNode> children = deptNode.getChildren();
          if (children == null) {
            children = Lists.newArrayList();
            deptNode.setChildren(children);
          }
          children.add(child);
        }
      }
    }
    List<DeptNode> result = new ArrayList<>(20);
    for (DeptNode node : nodes) {
      if (node.getPid() == 0) {
        result.add(node);
      }
    }
    return result;
  }

  public DeptRepository getDeptRepository() {
    return deptRepository;
  }

  public void setDeptRepository(DeptRepository deptRepository) {
    this.deptRepository = deptRepository;
  }
}
