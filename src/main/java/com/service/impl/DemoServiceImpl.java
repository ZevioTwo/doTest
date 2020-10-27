package com.service.impl;

import com.service.DemoService;
import com.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service("DemoService")
public class DemoServiceImpl implements DemoService {

    //初始化映射关系
    private final static String[] STRS = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static Map<Integer,String> map = null;

    static {
        map = new HashMap<Integer, String>();
        for(int i = 2;i<10;i++){
            map.put(i,STRS[i-2]);
        }
    }

    public String getTest1(int[] input){
        String outPut = "";
        //位数校验,过滤0和1
        if(StringUtils.checkParm(input,1)==null){
            return "此方法只支持0-9";
        }else {
            input = StringUtils.checkParm(input,1);
        }
        //数组长度为0
        if(input.length==0){
            return "";
        }
        //数组长度为1
        if(input.length==1){
            char[] as = map.get(input[0]).toCharArray();
            for (char a:as){
                outPut += a+""+" ";
            }
            return outPut;
        }
        //数组长度大于1
        Set set = new HashSet();
        for (int i = 0;i<input.length;i++){
            if(i+1==input.length){
                break;
            }
            char[] a = map.get(input[i]).toCharArray();
            char[] b = map.get(input[i+1]).toCharArray();
            for(int j = 0;j<a.length;j++){
                for (int k = 0;k<b.length;k++){
                    set.add(a[j]+""+b[k]+"");
                }
            }
        }
        outPut = StringUtils.removal(set);
        return outPut;
    }

    public String getTest2(int[] input){
        String outPut = "";
        //位数校验,过滤0和1
        if(StringUtils.checkParm(input,2)==null){
            return "此方法只支持0-99";
        }else {
            input = StringUtils.checkParm(input,2);
        }
        //数组长度为0
        if(input.length==0){
            return "";
        }
        //数组长度为1
        if(input.length==1){
            String str = StringUtils.getValString(input[0]+"",map);
            char[] as = str.toCharArray();
            for (char a:as){
                outPut += a+""+" ";
            }
            return outPut;
        }
        //数组长度大于1
        Set set = new HashSet();
        for (int i = 0;i<input.length;i++){
            if(i+1==input.length){
                break;
            }
            String  numa = input[i]+"";
            String stra = StringUtils.getValString(numa,map);
            char[] a = stra.toCharArray();
            String numb = input[i+1]+"";
            String strb = StringUtils.getValString(numb,map);
            char[] b = strb.toCharArray();
            for(int j = 0;j<a.length;j++){
                for (int k = 0;k<b.length;k++){
                    set.add(a[j]+""+b[k]+"");
                }
            }
        }
        outPut = StringUtils.removal(set);
        return outPut;
    }
}
