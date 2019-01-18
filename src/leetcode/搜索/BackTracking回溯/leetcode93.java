package leetcode.搜索.BackTracking回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 */
public class leetcode93 {

    public static void main(String[] args){
        String s = "25525511135";
        List<String> ans = restoreIpAddresses(s);
        for(int i = 0 ;i<ans.size();i++){
            System.out.print(ans.get(i)+"  ");
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        doRestore(0, tempAddress, addresses, s);
        return addresses;
    }

    //用k标记.的个数
    private static void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s) {
        //当k达到4而且s的长度为0时，说明s被分成了四个部分，同时s都被分配完全，此时存入address
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                addresses.add(tempAddress.toString());
            }
            return;
        }

        for(int i = 0;i<s.length()&&i<=2;i++){
            //排除第一个字符为0的情况
            if(i!=0&&s.charAt(0)=='0'){
                break;
            }
            String part = s.substring(0,i+1);
            if(Integer.valueOf(part)<=255){
                if(tempAddress.length()!=0){
                    part = "."+part;
                }
                tempAddress.append(part);
                doRestore(k+1,tempAddress,addresses,s.substring(i+1));
                tempAddress.delete(tempAddress.length()-part.length(),tempAddress.length());
            }
        }
    }
}
