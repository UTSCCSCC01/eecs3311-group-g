package Analysis;

import junit.framework.TestCase;
import java.util.*;

import org.junit.Test;

import dataGetters.*;
import static org.junit.Assert.*;
public class fossilFuelUsageTest {

@Test (timeout=30000)
	
	public void test_1() {
	String year1 = "2004";
	String year2 = "2010";
	String CC = "can";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1);
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	Vector<Double> dataList= fossilFuelUsage.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	
	}
	@Test (timeout=30000)
	
	public void test_2() {
	String year1 = "2000";
	String year2 = "2010";
	String CC = "bra";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1);
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	Vector<Double> dataList= fossilFuelUsage.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	
	}
	@Test (timeout=30000)
	public void test_3() {
	String year1 = "2000";
	String year2 = "2019";
	String CC = "chn";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1);
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	Vector<Double> dataList= fossilFuelUsage.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_4() {
	String year1 = "2000";
	String year2 = "2014";
	String CC = "chn";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1);
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	Vector<Double> dataList= fossilFuelUsage.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_5() {
	String year1 = "2000";
	String year2 = "2014";
	String CC = "chn";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1);
	Vector<Double> dataList= fossilFuelUsage.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_6() {
	String year1 = "2000";
	String year2 = "2009";
	String CC = "fra";
	
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue("String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1 );
	Vector<Double> dataList= fossilFuelUsage.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_7() {
	String year1 = "2000";
	String year2 = "2014";
	String CC = "usa";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1 );
	Vector<Double> dataList= fossilFuelUsage.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_8() {
	String year1 = "2000";
	String year2 = "2014";
	String CC = "chn";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1 );
	Vector<Double> dataList= fossilFuelUsage.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_9() {
	String year1 = "2000";
	String year2 = "2007";
	String CC = "fra";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1 );
	Vector<Double> dataList= fossilFuelUsage.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_10() {
	String year1 = "2002";
	String year2 = "2016";
	String CC = "fra";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1 );
	Vector<Double> dataList= fossilFuelUsage.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
}