package com.devonfw.tools.ide;

import org.assertj.core.api.Assertions;

import java.nio.file.Path;

/**
 * Abstract base classes for regular JUnit tests in this project.
 */
public abstract class IdeTest extends Assertions {

  public static final Path TEST_RESOURCES = Path.of("src/test/resources");

}
