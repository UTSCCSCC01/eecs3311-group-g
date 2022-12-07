package dataGetters;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class getDataCarbonEmTest {

	@Test
	public void testSetCC() {
		String expected = "can";
		getDataCarbonEm carb = new getDataCarbonEm();
		carb.setCC(expected);
		assertEquals(expected, carb.countryCode);
	}

	@Test
	public void testSetY1() {
		String expected = "1999";
		getDataCarbonEm carb = new getDataCarbonEm();
		carb.setY1(expected);
		assertEquals(expected, carb.urlP4);
	}

	@Test
	public void testSetY2() {
		String expected = "1999";
		getDataCarbonEm carb = new getDataCarbonEm();
		carb.setY2(expected);
		assertEquals(expected, carb.urlP5);
	}



	@Test
	public void testGetData() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataCarbonEm carb = new getDataCarbonEm();
		carb.setCC(cc);
		carb.setY1(y1);
		carb.setY2(y2);
		String test = carb.setFinalUrl();
		carb.dataRetrievedList = new Vector<Double>();
		Vector<Double> results = new Vector<Double>();
		results = carb.getData(test);
		assertEquals(results.size(), (Integer.parseInt(y2) - Integer.parseInt(y1))+1);
	}

	@Test
	public void testSetFinalUrl() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataCarbonEm carb = new getDataCarbonEm();
		carb.setCC(cc);
		carb.setY1(y1);
		carb.setY2(y2);
		carb.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/EN.ATM.CO2E.PC?date=1999:2004&format=json";
		assertEquals(expected, carb.getFinalURL());
	}	
	
	@Test
	public void testGetFinalURL() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataCarbonEm carb = new getDataCarbonEm();
		carb.setCC(cc);
		carb.setY1(y1);
		carb.setY2(y2);
		carb.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/EN.ATM.CO2E.PC?date=1999:2004&format=json";
		assertEquals(expected, carb.getFinalURL());
	}



}
