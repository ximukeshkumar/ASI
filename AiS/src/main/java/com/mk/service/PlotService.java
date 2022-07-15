package com.mk.service;

import java.util.List;

import com.mk.controller.payload.PlotDto;
import com.mk.data.model.Plot;

public interface PlotService extends CommonService{
	
	List<Plot> getAllPlots();
	
	Plot getPlotById(int id);
	
	Plot addNewPlot(PlotDto plotDto);
	
	Plot editPlot(PlotDto plotDto);

}
