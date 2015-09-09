package gov.usgs.volcanoes.util.args.decorator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Parameter;
import com.martiansoftware.jsap.ParseException;

import gov.usgs.volcanoes.util.args.Args;
import gov.usgs.volcanoes.util.args.Arguments;

/**
 * 
 * @author Tom Parker
 *
 */
public class VerboseArgTest {

  Arguments arg;

  /**
   * 
   * @throws JSAPException when things go wrong
   */
  @Before
  public void setUp() throws JSAPException {
    arg = new VerboseArg(new Args(null, null, new Parameter[0]));
  }

  /**
   * 
   * @throws Exception when things go wrong
   */
  @Test
  public void when_flagGiven_then_flagSet() throws Exception {
    String[] commandLine1 = {"--verbose"};
    JSAPResult jsapResult = arg.parse(commandLine1);
    assertTrue(jsapResult.getBoolean("verbose"));
  }

  /**
   * 
   * @throws Exception when things go wrong
   */
  @Test
  public void when_flagNotGiven_then_flagNotSet() throws Exception {
    JSAPResult jsapResult = arg.parse(new String[0]);
    assertFalse(jsapResult.getBoolean("verbose"));
  }

}
