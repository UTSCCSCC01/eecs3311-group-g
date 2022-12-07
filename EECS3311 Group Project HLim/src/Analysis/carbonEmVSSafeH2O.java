package Analysis;

import java.text.DecimalFormat;
import java.util.Vector;

import dataGetters.dataFactory;
import dataGetters.getDataAgriculture;
import dataGetters.getFFUseData;
import dataGetters.getPopDensData;
import dataGetters.getDataCarbonEm;
import dataGetters.getDataSafeH2O;

public class carbonEmVSSafeH2O implements MethodStrategy{
	public static Vector<Double> performAnalysis(String y1, String y2, String CC) {
		String x = "Population density";
		String y = "% Agricultural Land";
			int analysis1 = 8;
			int analysis2 = 2;
			final DecimalFormat dec = new DecimalFormat("0.00");
			
			Vector<Double> analysis = new Vector<Double>();
			Vector<Double> list1;
			Vector<Double> list2;
			
			getDataCarbonEm data1 = (getDataCarbonEm) dataFactory.createdataGetter(analysis1);
			data1.setCC(CC);
			data1.setY1(y1);
			data1.setY2(y2);
			data1.setFinalUrl();
			data1.dataRetrievedList = new Vector<Double>();
			list1 = data1.getData(data1.getFinalURL());
			
			getDataSafeH2O data2 = (getDataSafeH2O) dataFactory.createdataGetter(analysis2);
			data2.setCC(CC);
			data2.setY1(y1);
			data2.setY2(y2);
			data2.setFinalUrl();
			data2.dataRetrievedList = new Vector<Double>();
			list2 = data2.getData(data2.getFinalURL());

			
			for (int i = (list1.size()-1); i >= 0 ; i--) {
				analysis.add(Double. parseDouble(dec.format(list2.get(i)/list1.get(i))));
			}
			return analysis;	
	}
	
	
	public void methodAnalysis(String y1, String y2, String CC) {
		carbonEmVSSafeH2O.performAnalysis(y1, y2, CC);

	}

}