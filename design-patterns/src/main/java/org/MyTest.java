package org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2022-03-02 15:19
 */
public class MyTest {

    private static ThreadLocal<String> testStrLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
//        List<String> stringList = new CopyOnWriteArrayList<>();
//        for (int i = 0; i < 1000; i++){
//            int finalI = i;
//            Thread thread = new Thread(() -> {
//                testStrLocal.set(finalI + "haha");
//                stringList.add(finalI + "=>" + new Random().nextInt());
//                System.out.println("输出：" + testStrLocal.get());
//                testStrLocal.remove();
//            });
//            thread.start();
//            thread.join();
//        }
//        System.out.println(Arrays.asList(stringList) + "共" + stringList.size());

        List<String> list = Arrays.asList("111","222","333");
        System.out.println(list.stream().reduce((m, n) -> m + "," + n).get());
    }

    
}
