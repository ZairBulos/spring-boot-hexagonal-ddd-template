package com.zair.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(
        packages = "com.zair",
        importOptions = {ImportOption.DoNotIncludeTests.class}
)
class ArchitectureTest {

    @ArchTest
    static final ArchRule domain_should_not_depend_on_other_layers =
            classes().that().resideInAPackage("..domain..")
                    .should().onlyDependOnClassesThat()
                    .resideInAnyPackage("..domain..", "java..");

    @ArchTest
    static final ArchRule application_should_only_depend_on_domain =
            classes().that().resideInAPackage("..application..")
                    .should().onlyDependOnClassesThat()
                    .resideInAnyPackage("..application..", "..domain..", "java..");


    @ArchTest
    static final ArchRule infrastructure_should_only_depend_on_application_and_domain  =
            classes().that().resideInAPackage("..infrastructure..")
                    .should().onlyDependOnClassesThat()
                    .resideInAnyPackage(
                            "..infrastructure..",
                            "..application..",
                            "..domain..",
                            "java..",
                            "org.springframework..",
                            "jakarta..",
                            "org.slf4j..",
                            "lombok.."
                    );
}
