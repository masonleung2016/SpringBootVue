package cn.ue.flash.code;

import org.nutz.ioc.Ioc;

import java.util.Map;

/**
 * @Description: 基础的数据结构加载器
 * @Author: LCF
 * @Date: 2020/7/20 15:58
 * @Package: cn.ue.flash.code
 * @Version 1.0
 */

public abstract class AbstractLoader {

  public abstract Map<String, TableDescriptor> loadTables(Ioc ioc,
                                                          String basePackageName, String baseUri,
                                                          String servPackageName,
                                                          String repositoryPackageName,
                                                          String modPackageName) throws Exception;
}
