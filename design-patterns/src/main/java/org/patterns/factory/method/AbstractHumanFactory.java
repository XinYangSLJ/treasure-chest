package org.patterns.factory.method;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2021-12-06 17:08
 */
public abstract class AbstractHumanFactory {

    protected abstract <T extends IHuman> T createHuman(Class<T> c);

}
