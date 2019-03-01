package com.huishou.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

/**
 * <p/>
 * <li>Description:工具类</li>
 * <li>@author: wyp </li>
 * <li>@Date: 2018/07/02  </li>
 * <li>@version: 1.0 </li>
 */
public class CommonUtils {
    public static boolean isEmptyList(List list){
      return list == null || list.size() == 0;
    }
    public static boolean isNotEmptyList(List list){
        return isEmptyList(list) == false;
    }


    /**
     * 转换小数、
     * @param value 数据
     * @param decimal 小数位
     * @return 保留后数
     */
    public static double formatDecimal(double value,int decimal){
        BigDecimal bg = new BigDecimal(value);
        return bg.setScale(decimal, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
