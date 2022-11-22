package dataGetters;
public class dataFactory extends baseDataGetter{
	public static baseDataGetter createdataGetter(int dataType, String code, String y1, String y2)
    {
        if (dataType == 0)
            return null;
        switch (dataType) {
        case 1:
        	getDataGDPGrowth GDP = new getDataGDPGrowth();
        	GDP.setCC(code);
    		GDP.setY1(y1);
    		GDP.setY2(y2);
    		GDP.setFinalUrl();
    		return GDP;
        case 2:
        	getDataSafeH2O H2O = new getDataSafeH2O();
        	H2O.setCC(code);
        	H2O.setY1(y1);
        	H2O.setY2(y2);
        	H2O.setFinalUrl();
        	return H2O;
        case 3:
        	getFFUseData FF = new getFFUseData();
        	FF.setCC(code);
        	FF.setY1(y1);
        	FF.setY2(y2);
        	FF.setFinalUrl();
        	return FF;
        case 4:
        	getElectricityAcceData EAD = new getElectricityAcceData();
        	EAD.setCC(code);
        	EAD.setY1(y1);
        	EAD.setY2(y2);
        	EAD.setFinalUrl();
        	return EAD;
        case 5:
        	getInternetData GID = new getInternetData();
        	GID.setCC(code);
        	GID.setY1(y1);
        	GID.setY2(y2);
        	GID.setFinalUrl();
        	return GID;
        case 6:
        	getPopDensData GPDD = new getPopDensData();
        	GPDD.setCC(code);
        	GPDD.setY1(y1);
        	GPDD.setY2(y2);
        	GPDD.setFinalUrl();
        	return GPDD;
    	case 7:
    		getDataAgriculture GDA = new getDataAgriculture();
    		GDA.setCC(code);
    		GDA.setY1(y1);
    		GDA.setY2(y2);
    		GDA.setFinalUrl();
    		return GDA;
    	case 8:
    		getDataCarbonEm CEM = new getDataCarbonEm();
    		CEM.setCC(code);
    		CEM.setY1(y1);
    		CEM.setY2(y2);
    		CEM.setFinalUrl();
    	return CEM;
    	
    	default: return null;
    }

    
    }
}

