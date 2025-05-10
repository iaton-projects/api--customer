package br.com.iaquant.api.customer.user.architeture;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@AnalyzeClasses(packages = "br.com.iaquant.api.customer.user")
class ContractFirstTest {

    @ArchTest
    static ArchRule implementsValidator = ArchRuleDefinition.classes()
            .that().arePublic()
            .and().areAnnotatedWith(RestController.class).or().areAnnotatedWith(Controller.class)
            .should().implement(new DescribedPredicate<>("Deve implementar os controllers (..controller..)") {
                @Override
                public boolean test(JavaClass input) {
                    return input.getInterfaces().stream().map(imp -> ((JavaClass)imp).getPackageName())
                            .noneMatch(packageName -> packageName.contains("openapi.controller"));
                }
            });


}
