package Analysis;

import java.util.Vector;
import Analysis.Acc2ElecVsAcc2Net;
import org.junit.Test;

import junit.framework.TestCase;

public class Acc2ElecVsAcc2NetTest extends TestCase {
	@Test
	void test() {
		String year1 = "2004";
		String year2 = "2010";
		String CC = "can";
		Vector<Double> output = Acc2ElecVsAcc2Net.performAnalysis(year1, year2, CC);
		int actual = output.size();
		int expected = ((Integer.parseInt(year2) - Integer.parseInt(year1)) + 1);
		assertEquals("test failed", expected, actual);
	}
}
