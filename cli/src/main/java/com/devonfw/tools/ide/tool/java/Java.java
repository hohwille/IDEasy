package com.devonfw.tools.ide.tool.java;

import com.devonfw.tools.ide.common.Tag;
import com.devonfw.tools.ide.context.IdeContext;
import com.devonfw.tools.ide.process.EnvironmentContext;
import com.devonfw.tools.ide.tool.LocalToolCommandlet;
import com.devonfw.tools.ide.tool.ToolCommandlet;

import java.nio.file.Path;
import java.util.Set;

/**
 * {@link ToolCommandlet} for Java (Java Virtual Machine and Java Development Kit).
 */
public class Java extends LocalToolCommandlet {

  /**
   * The constructor.
   *
   * @param context the {@link IdeContext}.
   */
  public Java(IdeContext context) {

    super(context, "java", Set.of(Tag.JAVA, Tag.RUNTIME));
  }

  public void setEnvironment(EnvironmentContext context, Path toolPath) {

    context.withEnvVar("JAVA_HOME", toolPath.toString()).withEnvVar("JRE_HOME", toolPath.toString());
  }

}
