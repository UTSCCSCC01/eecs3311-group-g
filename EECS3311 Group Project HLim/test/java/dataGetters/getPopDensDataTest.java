package dataGetters;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class getPopDensDataTest {


	@Test
	public void testSetCC() {
		String expected = "can";
		getPopDensData popDens = new getPopDensData();
		popDens.setCC(expected);
		assertEquals(expected, popDens.countryCode);
	}

	@Test
	public void testSetY1() {
		String expected = "1999";
		getPopDensData popDens = new getPopDensData();
		popDens.setY1(expected);
		assertEquals(expected, popDens.urlP4);
	}

	@Test
	public void testSetY2() {
		String expected = "1999";
		getPopDensData popDens = new getPopDensData();
		popDens.setY2(expected);
		assertEquals(expected, popDens.urlP5);
	}



	@Test
	public void testGetData() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getPopDensData popDens = new getPopDensData();
		popDens.setCC(cc);
		popDens.setY1(y1);
		popDens.setY2(y2);
		String test = popDens.setFinalUrl();
		popDens.dataRetrievedList = new Vector<Double>();
		Vector<Double> results = new Vector<Double>();
		results = popDens.getData(test);
		assertEquals(results.size(), (Integer.parseInt(y2) - Integer.parseInt(y1))+1);
	}

	@Test
	public void testSetFinalUrl() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getPopDensData popDens = new getPopDensData();
		popDens.setCC(cc);
		popDens.setY1(y1);
		popDens.setY2(y2);
		popDens.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/EN.POP.DNST?date=1999:2004&format=json";
		assertEquals(expected, popDens.getFinalURL());
	}	
	
	@Test
	public void testGetFinalURL() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getPopDensData popDens = new getPopDensData();
		popDens.setCC(cc);
		popDens.setY1(y1);
		popDens.setY2(y2);
		popDens.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/EN.POP.DNST?date=1999:2004&format=json";
		assertEquals(expected, popDens.getFinalURL());
	}


}
