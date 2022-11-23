package dataGetters;
public class dataFactory extends baseDataGetter{
	public static baseDataGetter createdataGetter(int dataType)
    {
        if (dataType == 0)
            return null;
        switch (dataType) {
        case 1:
        	getDataGDPGrowth GDP = new getDataGDPGrowth();
    		return GDP;
        case 2:
        	getDataSafeH2O H2O = new getDataSafeH2O();
        	return H2O;
        case 3:
        	getFFUseData FF = new getFFUseData();
        	return FF;
        case 4:
        	getElectricityAcceData EAD = new getElectricityAcceData();
        	return EAD;
        case 5:
        	getInternetData GID = new getInternetData();
        	return GID;
        case 6:
        	getPopDensData GPDD = new getPopDensData();
        	return GPDD;
    	case 7:
    		getDataAgriculture GDA = new getDataAgriculture();
    		return GDA;
    	case 8:
    		getDataCarbonEm CEM = new getDataCarbonEm();
    	return CEM;
    	
    	default: return null;
    }

    
    }
}

