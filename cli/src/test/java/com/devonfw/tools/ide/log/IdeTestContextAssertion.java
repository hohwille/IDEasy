package com.devonfw.tools.ide.log;

import com.devonfw.tools.ide.context.IdeTestContext;

/**
 * Assertion for {@link IdeTestContext}.
 */
public class IdeTestContextAssertion {

  private final IdeTestContext context;

  /**
   * The constructor.
   *
   * @param context the {@link IdeTestContext}.
   */
  public IdeTestContextAssertion(IdeTestContext context) {
    super();
    this.context = context;
  }

  /**
   * @param level the {@link IdeLogLevel} to filter.
   * @return the {@link IdeTestLoggerAssertion}.
   */
  public IdeTestLoggerAssertion log(IdeLogLevel level) {

    return new IdeTestLoggerAssertion(context.level(IdeLogLevel.INFO).getEntries(), level); // random level - all loggers share the same list of log entries
  }

  /**
   * @return the {@link IdeTestLoggerAssertion}.
   */
  public IdeTestLoggerAssertion log() {
    return log(null);
  }

  /**
   * @return the {@link IdeTestLoggerAssertion} for assertion on {@link IdeLogLevel#DEBUG}.
   */
  public IdeTestLoggerAssertion logAtDebug() {
    return log(IdeLogLevel.DEBUG);
  }

  /**
   * @return the {@link IdeTestLoggerAssertion} for assertion on {@link IdeLogLevel#INFO}.
   */
  public IdeTestLoggerAssertion logAtInfo() {
    return log(IdeLogLevel.INFO);
  }

  /**
   * @return the {@link IdeTestLoggerAssertion} for assertion on {@link IdeLogLevel#SUCCESS}.
   */
  public IdeTestLoggerAssertion logAtSuccess() {
    return log(IdeLogLevel.SUCCESS);
  }

  /**
   * @return the {@link IdeTestLoggerAssertion} for assertion on {@link IdeLogLevel#WARNING}.
   */
  public IdeTestLoggerAssertion logAtWarning() {
    return log(IdeLogLevel.WARNING);
  }

  /**
   * @return the {@link IdeTestLoggerAssertion} for assertion on {@link IdeLogLevel#ERROR}.
   */
  public IdeTestLoggerAssertion logAtError() {
    return log(IdeLogLevel.ERROR);
  }

}
