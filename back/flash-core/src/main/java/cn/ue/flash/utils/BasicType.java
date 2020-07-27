package cn.ue.flash.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 基本变量类型的枚举
 * @Author: LCF
 * @Date: 2020/7/20 15:34
 * @Package: cn.ue.flash.utils
 * @Version 1.0
 */

public enum BasicType {
  BOOLEAN, BYTE, CHAR, CHARACTER, DOUBLE, FLOAT, INT, INTEGER, LONG, SHORT, STRING;

  /**
   * 原始类型为Key，包装类型为Value，例如： int.class -> Integer.class.
   */
  public static final Map<Class<?>, Class<?>> WRAPPER_PRIMITIVE_MAP = new HashMap<Class<?>, Class<?>>(8);
  /**
   * 包装类型为Key，原始类型为Value，例如： Integer.class -> int.class.
   */
  public static final Map<Class<?>, Class<?>> PRIMITIVE_WRAPPER_MAP = new HashMap<Class<?>, Class<?>>(8);

  static {
    WRAPPER_PRIMITIVE_MAP.put(Boolean.class, boolean.class);
    WRAPPER_PRIMITIVE_MAP.put(Byte.class, byte.class);
    WRAPPER_PRIMITIVE_MAP.put(Character.class, char.class);
    WRAPPER_PRIMITIVE_MAP.put(Double.class, double.class);
    WRAPPER_PRIMITIVE_MAP.put(Float.class, float.class);
    WRAPPER_PRIMITIVE_MAP.put(Integer.class, int.class);
    WRAPPER_PRIMITIVE_MAP.put(Long.class, long.class);
    WRAPPER_PRIMITIVE_MAP.put(Short.class, short.class);

    for (Map.Entry<Class<?>, Class<?>> entry : WRAPPER_PRIMITIVE_MAP.entrySet()) {
      PRIMITIVE_WRAPPER_MAP.put(entry.getValue(), entry.getKey());
    }
  }

  public static Map<Class<?>, Class<?>> getWrapperPrimitiveMap() {
    return WRAPPER_PRIMITIVE_MAP;
  }

  public static Map<Class<?>, Class<?>> getPrimitiveWrapperMap() {
    return PRIMITIVE_WRAPPER_MAP;
  }
}