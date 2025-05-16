package br.com.iaquant.api.customer.user.datasource;

import br.com.iaquant.api.customer.user.aspect.ReturnRepositoryElement;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public abstract class AbstractDataSourceTest {


    protected AspectJProxyFactory factory;

    public <T> T setupDataSourceTest(T dataSource) {
        this.factory = new AspectJProxyFactory(dataSource);
        this.factory.setProxyTargetClass(true); // força CGLIB
        this.factory.addAspect(new ReturnRepositoryElement());
        return this.factory.getProxy();
    }

}
