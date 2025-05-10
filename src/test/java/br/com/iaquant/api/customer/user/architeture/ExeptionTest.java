package br.com.iaquant.api.customer.user.architeture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "br.com.iaquant.api.customer.user")
class ExeptionTest {

    @ArchTest
    static ArchRule noThrowsGenericException = noClasses().should(GeneralCodingRules.THROW_GENERIC_EXCEPTIONS)
            .andShould().resideOutsideOfPackage("..openapi.controller..");


}
