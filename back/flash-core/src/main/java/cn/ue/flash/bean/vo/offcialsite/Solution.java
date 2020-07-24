package cn.ue.flash.bean.vo.offcialsite;

import lombok.Data;

/**
 * @Description:
 * @Author: LCF
 * @Date: 2020/7/20 14:33
 * @Package: cn.ue.flash.bean.vo.offcialsite
 * @Version 1.0
 */

@Data
public class Solution {

    private Long id;
    private String name;
    private String img;

    public Solution() {

    }

    public Solution(Long id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public Solution(Long id, Object title, Object img) {

    }

    public void setId(Long id) {

    }

    public void setName(Object title) {

    }

    public void setImg(Object img) {

    }
}
