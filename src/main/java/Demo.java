import java.util.*;

public class Demo {

    /**
     * 支持0-9输入
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
            return "此方法只支持0-9";
        }else {
            input = checkParm(input);
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
        for (int i = 0;i<input.length;i++){
            if(i+1==input.length){
                break;
            }
            char[] a = map.get(input[i]).toCharArray();
            char[] b = map.get(input[i+1]).toCharArray();
            for(int j = 0;j<a.length;j++){
                for (int k = 0;k<b.length;k++){
                    outPut += a[j]+""+b[k]+""+" ";
                }
            }
        }
        return outPut;
    }

    /**
     * 数组里的数只允许1位数，过滤0和1
     * @param input
     * @return
     */
    public static int[] checkParm(int[] input){
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0;i<input.length;i++){
            if(String.valueOf(input[i]).length()>1){
                return null;
            }
            if(input[i]!=0 && input[i]!=1){
                list.add(input[i]);
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
        String str = change(new int[]{2,5,7,0,8,11});
        System.out.println(str);
    }

}
