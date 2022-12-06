package dataGetters;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class getDataGDPGrowthTest {

	@Test
	public void testSetCC() {
		String expected = "can";
		getDataGDPGrowth gdp = new getDataGDPGrowth();
		gdp.setCC(expected);
		assertEquals(expected, gdp.countryCode);
	}

	@Test
	public void testSetY1() {
		String expected = "1999";
		getDataGDPGrowth gdp = new getDataGDPGrowth();
		gdp.setY1(expected);
		assertEquals(expected, gdp.urlP4);
	}

	@Test
	public void testSetY2() {
		String expected = "1999";
		getDataGDPGrowth gdp = new getDataGDPGrowth();
		gdp.setY2(expected);
		assertEquals(expected, gdp.urlP5);
	}



	@Test
	public void testGetData() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataGDPGrowth gdp = new getDataGDPGrowth();
		gdp.setCC(cc);
		gdp.setY1(y1);
		gdp.setY2(y2);
		String test = gdp.setFinalUrl();
		gdp.dataRetrievedList = new Vector<Double>();
		Vector<Double> results = new Vector<Double>();
		results = gdp.getData(test);
		assertEquals(results.size(), (Integer.parseInt(y2) - Integer.parseInt(y1))+1);
	}

	@Test
	public void testSetFinalUrl() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataGDPGrowth gdp = new getDataGDPGrowth();
		gdp.setCC(cc);
		gdp.setY1(y1);
		gdp.setY2(y2);
		gdp.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/NY.GDP.MKTP.KD.ZG?date=1999:2004&format=json";
		assertEquals(expected, gdp.getFinalURL());
	}	
	
	@Test
	public void testGetFinalURL() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataGDPGrowth gdp = new getDataGDPGrowth();
		gdp.setCC(cc);
		gdp.setY1(y1);
		gdp.setY2(y2);
		gdp.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/NY.GDP.MKTP.KD.ZG?date=1999:2004&format=json";
		assertEquals(expected, gdp.getFinalURL());
	}

}
