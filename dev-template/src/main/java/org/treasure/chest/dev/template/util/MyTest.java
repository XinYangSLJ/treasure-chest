package org.treasure.chest.dev.template.util;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2022-06-15 12:12
 */
public class MyTest {

    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayList("a",null,null);
        String reduce = stringList.stream()
                .reduce((str1, str2) -> str1.concat(","+str2)).orElse("");
        System.out.println(reduce);
    }
}
