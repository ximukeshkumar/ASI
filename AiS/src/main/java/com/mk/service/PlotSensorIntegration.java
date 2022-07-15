package com.mk.service;

import com.mk.data.model.IrrigationTransaction;

public interface PlotSensorIntegration extends CommonService{
	
	boolean executePlotIntegration(IrrigationTransaction irrigationTransaction);

}
