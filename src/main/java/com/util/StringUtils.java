package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringUtils {

    /**
     * 返回所需英文字母串
     * @param set
     * @return
     */
    public static String removal(Set<String> set){
        String str = "";
        for (String s:set){
            str+=s+" ";
        }
        return str;
    }

    /**
     * 获取初始化的目标值
     * @param str
     * @param map
     * @return
     */
    public static String getValString(String str, Map<Integer,String> map){
        String result = "";
        if((str).length()>1){
            result = map.get(Integer.parseInt(str.substring(0,1)))+map.get(Integer.parseInt(str.substring(1)));
        }else {
            result = map.get(Integer.parseInt(str));
        }
        return result;
    }

    /**
     * 数组里的数只允许2位数，过滤0和1,切割0和1
     * @param input
     * @param num 1:test1 2:test2
     * @return
     */
    public static int[] checkParm(int[] input,int num){
        List<Integer> list = new ArrayList<Integer>();
        if(num==1){
            for (int i = 0;i<input.length;i++){
                if(String.valueOf(input[i]).length()>1){
                    return null;
                }
                if(input[i]!=0 && input[i]!=1){
                    list.add(input[i]);
                }
            }
        }else {
            for (int i = 0;i<input.length;i++){
                if(String.valueOf(input[i]).length()>2){
                    return null;
                }
                if(input[i]!=0 && input[i]!=1){
                    String str = String.valueOf(input[i]);
                    if(str.contains("0")){
                        str = str.replace("0","");
                    }
                    if(str.contains("1")){
                        str = str.replace("1","");
                    }
                    if(!"".equals(str)){
                        list.add(Integer.valueOf(str));
                    }
                }
            }
        }
        Integer []b=new Integer[list.size()];
        list.toArray(b);
        int []c=new int[b.length];
        for(int i=0;i<b.length;i++) {
            c[i]=b[i].intValue();
        }
        return c;
    }
}
