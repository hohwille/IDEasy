package com.devonfw.tools.ide.url.model.file;

import com.devonfw.tools.ide.json.mapping.JsonMapping;
import com.devonfw.tools.ide.url.model.file.json.StatusJson;
import com.devonfw.tools.ide.url.model.folder.UrlEdition;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * {@link UrlFile} for the "status.json" file.
 */
public class UrlDependencyFile extends AbstractUrlFile<UrlEdition> {

  /**
   * Constant {@link UrlDependencyFile#getName() filename}.
   */
  public static final String DEPENDENCY_JSON = "dependency.json";

  private static final ObjectMapper MAPPER = JsonMapping.create();

  private StatusJson statusJson;

  /**
   * The constructor.
   *
   * @param parent the {@link #getParent() parent folder}.
   */
  public UrlDependencyFile(UrlEdition parent) {

    super(parent, DEPENDENCY_JSON);
  }

  /**
   * @return the content of the {@link StatusJson status.json} file.
   */
  public StatusJson getDependencyJson() {

    return this.statusJson;
  }

  @Override
  protected void doLoad() {

    Path path = getPath();
    if (Files.exists(path)) {
      try (BufferedReader reader = Files.newBufferedReader(path)) {
        this.statusJson = MAPPER.readValue(reader, StatusJson.class);
      } catch (Exception e) {
        throw new IllegalStateException("Failed to load " + path, e);
      }
    } else {
      this.statusJson = new StatusJson();
    }
  }

  @Override
  protected void doSave() {

  }

}
