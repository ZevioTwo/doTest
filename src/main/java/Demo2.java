import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo2 {

    /**
     * 支持0-99输入
     * @param input
     * @return
     */
    public static String change(int[] input){
        //建立映射
        String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Map<Integer,String> map = new HashMap<Integer, String>();
        for(int i = 2;i<10;i++){
            map.put(i,strs[i-2]);
        }
//        System.out.println(map.toString());
        String outPut = "";
        //位数校验,过滤0和1
        if(checkParm(input)==null){
            return "此方法只支持0-99";
        }else {
            input = checkParm(input);
        }
        //数组长度为0
        if(input.length==0){
            return "";
        }
        //数组长度为1
        if(input.length==1){
            String str = getValString(input[0]+"",map);
            char[] as = str.toCharArray();
            for (char a:as){
                outPut += a+""+" ";
            }
            return outPut;
        }
        //数组长度大于1
        for (int i = 0;i<input.length;i++){
            if(i+1==input.length){
                break;
            }
            String  numa = input[i]+"";
            String stra = getValString(numa,map);
            char[] a = stra.toCharArray();
            String numb = input[i+1]+"";
            String strb = getValString(numb,map);
            char[] b = strb.toCharArray();
            for(int j = 0;j<a.length;j++){
                for (int k = 0;k<b.length;k++){
                    outPut += a[j]+""+b[k]+""+" ";
                }
            }
        }
        return outPut;
    }

    public static String getValString(String str,Map<Integer,String> map){
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
     * @return
     */
    public static int[] checkParm(int[] input){
        List<Integer> list = new ArrayList<Integer>();
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
        Integer []b=new Integer[list.size()];
        list.toArray(b);
        int []c=new int[b.length];
        for(int i=0;i<b.length;i++) {
            c[i]=b[i].intValue();
        }
        return c;
    }

    public static void main(String[] arg){
        String str = change(new int[]{22,90,31});
        System.out.println(str);
    }

}
