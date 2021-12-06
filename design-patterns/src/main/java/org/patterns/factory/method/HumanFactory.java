package org.patterns.factory.method;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-06 17:13
 */
public class HumanFactory extends AbstractHumanFactory {
    
    @Override
    protected <T extends IHuman> T createHuman(Class<T> c) {
        IHuman human = null;
        try {
            human = (T)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)human;
    }
}
