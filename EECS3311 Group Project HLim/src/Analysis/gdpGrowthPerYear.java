package Analysis;

import java.util.Vector;

import dataGetters.dataFactory;
import dataGetters.getDataGDPGrowth;


public class gdpGrowthPerYear {
	public static Vector<Double> performAnalysis(String y1, String y2, String CC){
	Vector<Double> analysis = new Vector<Double>();
	int analysis1 = 1;
	getDataGDPGrowth data1 = (getDataGDPGrowth) dataFactory.createdataGetter(analysis1);
	data1.setCC(CC);
	data1.setY1(y1);
	data1.setY2(y2);
	data1.setFinalUrl();
	data1.dataRetrievedList = new Vector<Double>();
	analysis = data1.getData(data1.getFinalURL());
	
	return analysis;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String year1 = "2004";
		String year2 = "2010";
		String CC = "can";
		Vector<Double> output = performAnalysis(year1, year2, CC);
		
		for(int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}
	}

}
