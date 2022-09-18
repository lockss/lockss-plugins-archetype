package ${package};

import java.io.*;
import java.util.*;

import org.lockss.daemon.*;
import org.lockss.plugin.*;
import org.lockss.util.*;
import org.lockss.util.urlconn.*;

/**
 * Demonstration ContentValidator
 */
public class PdfContentValidator implements ContentValidator {

  public void validate(CachedUrl cu)
      throws ContentValidationException, PluginException, IOException {

    // Check the response headers for an expected value, reject file if not
    // found.
    CIProperties headers = cu.getProperties();
    // Check some
    String some_val = headers.getProperty("some_prop");
    if (some_val != "some_string") {
      throw new InvalidReponseHeaderException("msg");
    }
    // May also read the content to check type, determine if well-formed,
    // etc.
    if (isTruncatedPdf(cu.getUnfilteredInputStream())) {
      throw new TruncatedPdfException("msg");
    }

    // If a redirect occurred, the CachedUrl argument reflects the original
    // URL, the response headers are those from the final, non-redirect
    // response, and the list of redirected-to URLs (not including the
    // original URL) in the CachedUrl.PROPERTY_VALIDATOR_REDIRECT_URLS
    // property.  (This is a List, which must be retrieved using Map.get(),
    // not Properties.getProperty()).

    List<String> redirUrls =
        (List<String>) headers.get(CachedUrl.PROPERTY_VALIDATOR_REDIRECT_URLS);
    // ...
  }

  boolean isTruncatedPdf(InputStream ins) {
    return false;
  }

  /**
   * Factory class, name goes in plugin
   */
  public static class Factory implements ContentValidatorFactory {

    public ContentValidator createContentValidator(ArchivalUnit au,
                                                   String contentType) {
      // content type available but need not be used.
      return new PdfContentValidator();
    }
  }

  /**
   * Defining an exception specific to this condition facilitates custom
   * action, specified in plugin.
   */
  public static class InvalidReponseHeaderException
      extends ContentValidationException {

    public InvalidReponseHeaderException(String msg) {
      super(msg);
    }
  }

  public static class TruncatedPdfException
      extends ContentValidationException {

    public TruncatedPdfException(String msg) {
      super(msg);
    }
  }


}

