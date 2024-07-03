package com.devonfw.tools.ide.process;

public interface EnvironmentContext {
  /**
   * Sets or overrides the specified environment variable only for the planned {@link ProcessContext#run() process execution}. Please
   * note that the environment variables are initialized when the {@link ProcessContext} is created. This method
   * explicitly set an additional or overrides an existing environment and will have effect for each {@link ProcessContext#run()
   * process execution} invoked from this {@link ProcessContext} instance. Be aware of such side-effects when reusing
   * the same {@link ProcessContext} to {@link ProcessContext#run() run} multiple commands.
   *
   * @param key   the name of the environment variable (E.g. "PATH").
   * @param value the value of the environment variable.
   * @return this {@link ProcessContext} for fluent API calls.
   */
  EnvironmentContext withEnvVar(String key, String value);
}
