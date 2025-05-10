package br.com.iaquant.api.customer.user.usecase;

import br.com.iaquant.api.customer.user.aspect.ReturnRepositoryElement;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public abstract class AbstractUseCaseTest {


    protected AspectJProxyFactory factory;

    public <T> T setupUseCaseTest(T useCase) {
        this.factory = new AspectJProxyFactory(useCase);
        this.factory.addAspect(new ReturnRepositoryElement());
        return this.factory.getProxy();
    }

}
