package org.treasure.chest.dev.template.util;

import com.google.common.collect.Lists;
import freemarker.template.utility.DateUtil;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2022-06-15 12:12
 */
public class MyTest {

    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayList();
        List<String> stringList2 = Lists.newArrayList("a","b","c");

//        List<String> cList = stringList.subList(1,stringList.size());
        String reduce = stringList.stream()
                .reduce((str1, str2) -> str1.concat(","+str2)).orElse("");
//        String reduce = stringList.stream()
//                .reduce("",(str1, str2) -> String.format("%s,%s", str1, str2));
        System.out.println(String.format("%s_%s_%s", 12345L, 232L, "20220801144511"));


        List<String> collect = stringList.stream()
                .filter(p -> "d".equals(p)).collect(Collectors.toList());
        System.out.println(collect);

//
//        String str = null;
//        switch (str){
//            case ("A"):
//                System.out.println("A");
//                break;
//            case ("B"):
//                System.out.println("B");
//                break;
//            default:
//        }


        String str1 = "28-2500193";
        String[] outerShopCustomerCodeArray = str1.split("-");
        System.out.println(""+ outerShopCustomerCodeArray[1] +"    " + outerShopCustomerCodeArray[0]);
    }
}
