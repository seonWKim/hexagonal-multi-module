package org.example;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption.Predefined;
import com.tngtech.archunit.lang.ArchRule;

public class ArchitectureTest {
    private final JavaClasses classes = new ClassFileImporter(
            List.of(Predefined.DO_NOT_INCLUDE_TESTS))
            .importPackages("org.example");

    @Test
    public void domain_package_should_not_access_other_packages() {
        final ArchRule rule = noClasses()
                .that().resideInAPackage("..domain..")
                .should().dependOnClassesThat().resideInAnyPackage("..application..", "..adapter..");
        rule.check(classes);
    }

    @Test
    public void application_package_should_not_access_adapter_package() {
        final ArchRule rule = noClasses()
                .that().resideInAPackage("..application..")
                .should().dependOnClassesThat().resideInAnyPackage("..adapter..");
        rule.check(classes);
    }
}
