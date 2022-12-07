package Analysis;

import java.text.DecimalFormat;
import java.util.Vector;

import dataGetters.dataFactory;
import dataGetters.getDataCarbonEm;
import dataGetters.getDataSafeH2O;

public class accessToSafeWater implements MethodStrategy{
	public static Vector<Double> performAnalysis(String y1, String y2, String CC){
	final DecimalFormat dec = new DecimalFormat("0.00");

	Vector<Double> analysis = new Vector<Double>();
	getDataSafeH2O data1 = (getDataSafeH2O) dataFactory.createdataGetter(2);
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
		// TODO Auto-generated method stub
		accessToSafeWater.performAnalysis(y1, y2, CC);
	}
	

}
