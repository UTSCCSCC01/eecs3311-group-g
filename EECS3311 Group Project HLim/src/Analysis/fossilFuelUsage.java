package Analysis;

import java.text.DecimalFormat;
import java.util.Vector;

import dataGetters.dataFactory;
import dataGetters.getDataCarbonEm;
import dataGetters.getDataSafeH2O;
import dataGetters.getFFUseData;

public class fossilFuelUsage implements MethodStrategy{
	public static Vector<Double> performAnalysis(String y1, String y2, String CC){
	Vector<Double> analysis = new Vector<Double>();
	int analysis1 = 3;
	final DecimalFormat dec = new DecimalFormat("0.00");
	getFFUseData data1 = (getFFUseData) dataFactory.createdataGetter(analysis1);
	data1.setCC(CC);
	data1.setY1(y1);
	data1.setY2(y2);
	data1.setFinalUrl();
	data1.dataRetrievedList = new Vector<Double>();
	analysis = data1.getData(data1.getFinalURL());
	for(int i = 0; i < analysis.size(); i++) {
		double temp = Double.parseDouble(dec.format(analysis.get(i)));
		analysis.set(i, temp);
	}
	
	return analysis;
	
	}
	
	
	public void methodAnalysis(String y1, String y2, String CC) {
		fossilFuelUsage.performAnalysis(y1, y2, CC);

	}


}
