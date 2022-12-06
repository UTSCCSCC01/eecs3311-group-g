package dataGetters;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class getInternetDataTest {


	@Test
	public void testSetCC() {
		String expected = "can";
		getInternetData net = new getInternetData();
		net.setCC(expected);
		assertEquals(expected, net.countryCode);
	}

	@Test
	public void testSetY1() {
		String expected = "1999";
		getInternetData net = new getInternetData();
		net.setY1(expected);
		assertEquals(expected, net.urlP4);
	}

	@Test
	public void testSetY2() {
		String expected = "1999";
		getInternetData net = new getInternetData();
		net.setY2(expected);
		assertEquals(expected, net.urlP5);
	}



	@Test
	public void testGetData() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getInternetData net = new getInternetData();
		net.setCC(cc);
		net.setY1(y1);
		net.setY2(y2);
		String test = net.setFinalUrl();
		net.dataRetrievedList = new Vector<Double>();
		Vector<Double> results = new Vector<Double>();
		results = net.getData(test);
		assertEquals(results.size(), (Integer.parseInt(y2) - Integer.parseInt(y1))+1);
	}

	@Test
	public void testSetFinalUrl() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getInternetData net = new getInternetData();
		net.setCC(cc);
		net.setY1(y1);
		net.setY2(y2);
		net.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/IT.NET.USER.ZS?date=1999:2004&format=json";
		assertEquals(expected, net.getFinalURL());
	}	
	
	@Test
	public void testGetFinalURL() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getInternetData net = new getInternetData();
		net.setCC(cc);
		net.setY1(y1);
		net.setY2(y2);
		net.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/IT.NET.USER.ZS?date=1999:2004&format=json";
		assertEquals(expected, net.getFinalURL());
	}

}
