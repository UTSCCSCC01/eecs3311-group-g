package Analysis;
import java.util.Iterator;

import java.util.List;
import java.util.Vector;

import dataGetters.*;
public class popDensVsAgricLand {
	String x = "Population density";
	String y = "% Agricultural Land";
	public static Vector<Double> performAnalysis(String y1, String y2, String CC){
		int analysis1 = 6;
		int analysis2 = 7;
		
		Vector<Double> analysis = new Vector<Double>();
		Vector<Double> list1;
		Vector<Double> list2;
		
		getPopDensData data1 = (getPopDensData) dataFactory.createdataGetter(analysis1);
		data1.setCC(CC);
		data1.setY1(y1);
		data1.setY2(y2);
		data1.setFinalUrl();
		data1.dataRetrievedList = new Vector<Double>();
		list1 = data1.getData(data1.getFinalURL());
		
		getDataAgriculture data2 = (getDataAgriculture) dataFactory.createdataGetter(analysis2);
		data2.setCC(CC);
		data2.setY1(y1);
		data2.setY2(y2);
		data2.setFinalUrl();
		data2.dataRetrievedList = new Vector<Double>();
		list2 = data2.getData(data2.getFinalURL());

		
		for (int i = 0; i < list1.size(); i++) {
			analysis.add(list2.get(i)/list1.get(i));
		}
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
<<<<<<< HEAD
	//Strategy design Pattern
	@Override
	public void methodAnalysis(String y1, String y2, String CC) {
		popDensVsAgricLand.performAnalysis(y1, y2, CC);
		
	}
=======
>>>>>>> 2b3db633d7741e78431f6bd75169eecba98d7c70

}
