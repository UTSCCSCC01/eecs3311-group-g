package dataGetters;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class getDataSafeH2OTest {

	@Test
	public void testSetCC() {
		String expected = "can";
		getDataSafeH2O safeH2O = new getDataSafeH2O();
		safeH2O.setCC(expected);
		assertEquals(expected, safeH2O.countryCode);
	}

	@Test
	public void testSetY1() {
		String expected = "1999";
		getDataSafeH2O safeH2O = new getDataSafeH2O();
		safeH2O.setY1(expected);
		assertEquals(expected, safeH2O.urlP4);
	}

	@Test
	public void testSetY2() {
		String expected = "1999";
		getDataSafeH2O safeH2O = new getDataSafeH2O();
		safeH2O.setY2(expected);
		assertEquals(expected, safeH2O.urlP5);
	}



	@Test
	public void testGetData() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataSafeH2O safeH2O = new getDataSafeH2O();
		safeH2O.setCC(cc);
		safeH2O.setY1(y1);
		safeH2O.setY2(y2);
		String test = safeH2O.setFinalUrl();
		safeH2O.dataRetrievedList = new Vector<Double>();
		Vector<Double> results = new Vector<Double>();
		results = safeH2O.getData(test);
		assertEquals(results.size(), (Integer.parseInt(y2) - Integer.parseInt(y1))+1);
	}

	@Test
	public void testSetFinalUrl() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataSafeH2O safeH2O = new getDataSafeH2O();
		safeH2O.setCC(cc);
		safeH2O.setY1(y1);
		safeH2O.setY2(y2);
		safeH2O.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/SH.H2O.SMDW.ZS?date=1999:2004&format=json";
		assertEquals(expected, safeH2O.getFinalURL());
	}	
	
	@Test
	public void testGetFinalURL() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataSafeH2O safeH2O = new getDataSafeH2O();
		safeH2O.setCC(cc);
		safeH2O.setY1(y1);
		safeH2O.setY2(y2);
		safeH2O.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/SH.H2O.SMDW.ZS?date=1999:2004&format=json";
		assertEquals(expected, safeH2O.getFinalURL());
	}


}
