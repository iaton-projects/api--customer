package br.com.iaquant.api.customer.user.architeture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = "br.com.iaquant.api.customer.user")
class HexagonalTest {

    @ArchTest
    static ArchRule layersValidator = Architectures.layeredArchitecture()
            .consideringOnlyDependenciesInLayers()
            .layer("Config").definedBy("..config..")
            .layer("Controller").definedBy("..controller..")
            .layer("UseCase").definedBy("..usecase..")
            .layer("Repository").definedBy("..repository..")
            .layer("DataSource").definedBy("..datasource..")
            .layer("Mapper").definedBy("..mapper..")
            .layer("Entities").definedBy("..entity..")
            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Config").mayOnlyBeAccessedByLayers("Controller", "UseCase","DataSource")
            .whereLayer("Mapper").mayOnlyBeAccessedByLayers("Controller","DataSource")
            .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Controller", "Config")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("UseCase","DataSource")
            .whereLayer("DataSource").mayOnlyBeAccessedByLayers("Repository","Mapper");

}
