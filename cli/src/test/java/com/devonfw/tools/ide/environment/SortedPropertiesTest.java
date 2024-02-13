package com.devonfw.tools.ide.environment;

import com.devonfw.tools.ide.IdeTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

/**
 * Test of {@link SortedProperties}.
 */
public class SortedPropertiesTest extends IdeTest {

  /**
   * Test of {@link SortedProperties}.
   *
   * @throws Exception on error.
   */
  @Test
  public void test() throws Exception {

    // given
    SortedProperties properties = new SortedProperties();
    properties.setProperty("zz", "top");
    properties.setProperty("middle", "man");
    properties.setProperty("alpha", "omega");
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    OutputStreamWriter out = new OutputStreamWriter(buffer);
    // when
    properties.store(out, null);
    // then
    String result = buffer.toString().replaceAll("#.*(\r\n|\r|\n)", ""); // remove invariant date header
    String newline = System.lineSeparator();
    assertThat(result).isEqualTo("alpha=omega" + newline //
        + "middle=man" + newline //
        + "zz=top" + newline);
  }

}
