package ${package};

import java.io.*;

import org.lockss.daemon.*;
import org.lockss.plugin.*;
import org.lockss.util.*;
import org.lockss.util.urlconn.*;

/**
 * Example of collection of validators for various mime-types
 */
public class AllContentValidator {

  public static class HtmlContentValidator implements ContentValidator {

    public void validate(CachedUrl cu)
        throws ContentValidationException, PluginException, IOException {
//     ...
    }
  }

  public static class XmlContentValidator implements ContentValidator {

    public void validate(CachedUrl cu)
        throws ContentValidationException, PluginException, IOException {
//     ...
    }
  }

  /**
   * This factory is used to create validators for all mime types other
   * than pdf.
   */
  public static class Factory implements ContentValidatorFactory {

    /**
     * May create a mime-type specific validator here, or a general
     * purpose one which checks the mime-type when invoked on a specific
     * file.
     */
    public ContentValidator createContentValidator(ArchivalUnit au,
                                                   String contentType) {
      switch (HeaderUtil.getMimeTypeFromContentType(contentType)) {
        case "text/html":
          return new HtmlContentValidator();
        case "text/xml":
          return new XmlContentValidator();
        default:
          return null;
      }
    }
  }

}

