package org.patterns.singleton;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-06 11:19
 */
public class Emperor {
    private static final Emperor emperor = new Emperor();

    private Emperor(){}

    public static Emperor getInstance(){
        return emperor;
    }

    public void say(){
        System.out.println("朕！！！");
    }

}
