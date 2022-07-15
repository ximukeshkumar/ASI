package com.mk.data.dataseed;

import java.time.LocalDateTime;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mk.data.enums.IrrigationTransactionStatus;
import com.mk.data.model.Crop;
import com.mk.data.model.IrrigationTransaction;
import com.mk.data.model.Plot;
import com.mk.data.model.PlotAlert;
import com.mk.data.model.PlotConfiguration;
import com.mk.data.model.PlotSensor;
import com.mk.data.repositories.CropRepository;
import com.mk.data.repositories.PlotAlertRepository;
import com.mk.data.repositories.PlotRepository;


@Component
public class IrrigationDataLoader implements CommandLineRunner {

	@Autowired
	PlotRepository plotRepository;
	
	@Autowired
	CropRepository cropRepository;
	
	@Autowired
	PlotAlertRepository plotAlertRepository;

	@Override
	public void run(String... args) throws Exception {
		
		loadCropData();
		
		loadTestCase0Data();
		loadTestCase1Data();
		loadTestCase2Data();
		loadTestCase3Data();
		
	}

	private void loadCropData() {
		Crop crop = new Crop();		
		crop.setName("potatos");
		crop.setIrrigationRate(5);
		crop.setWaterAmountUnit(100);
		
		cropRepository.save(crop);
		
		crop = new Crop();
		crop.setName("ladyfinger");
		crop.setIrrigationRate(6);
		crop.setWaterAmountUnit(500);
		
		cropRepository.save(crop);
		
		crop = new Crop();
		crop.setName("gram");
		crop.setIrrigationRate(2);
		crop.setWaterAmountUnit(300);
		
		cropRepository.save(crop);
		
		crop = new Crop();
		crop.setName("ٌrice");
		crop.setIrrigationRate(4);
		crop.setWaterAmountUnit(600);
		
		cropRepository.save(crop);	
	}
	
	private void loadTestCase0Data() {
		Plot plot = new Plot();
		
		plot.setLocation("Jamui,Sikandra");
		plot.setOwnerName("Rana rajbhar");
		plot.setArea(90);
		plot.setLastIrragtionDate(LocalDateTime.now());
		
		//plot sensor
		PlotSensor plotSensor = new PlotSensor();
		plotSensor.setAvailable(true);
		plot.setPlotSensor(plotSensor);
	
		//plot configurations
		PlotConfiguration plotConfiguration = new PlotConfiguration();
		Crop crop = cropRepository.findByName("gram").get();
		plotConfiguration.setCrop(crop);
		plotConfiguration.setPlot(plot);
		plotConfiguration.setCurrentConfig(true);
		plotConfiguration.setIrrigationRate(crop.getIrrigationRate());
		plotConfiguration.setWaterAmount(crop.getWaterAmountUnit()*plot.getArea());
		
		plot.setNextIrragtionDate(LocalDateTime.now().plusMinutes(plotConfiguration.getIrrigationRate()));

		plot.setPlotConfigurations(Set.of(plotConfiguration));
		
		plotRepository.save(plot);
}

	private void loadTestCase1Data() {
			Plot plot = new Plot();
			
			plot.setLocation("Jamui,jhajha");
			plot.setOwnerName("Rajkumar");
			plot.setArea(70);
			plot.setLastIrragtionDate(LocalDateTime.now());
			
			//plot sensor
			PlotSensor plotSensor = new PlotSensor();
			plotSensor.setAvailable(true);
			plot.setPlotSensor(plotSensor);
		
			//plot configurations
			PlotConfiguration plotConfiguration = new PlotConfiguration();
			Crop crop = cropRepository.findByName("ladyfinger").get();
			plotConfiguration.setCrop(crop);
			plotConfiguration.setPlot(plot);
			plotConfiguration.setCurrentConfig(true);
			plotConfiguration.setIrrigationRate(crop.getIrrigationRate());
			plotConfiguration.setWaterAmount(crop.getWaterAmountUnit()*plot.getArea());
			
			plot.setNextIrragtionDate(LocalDateTime.now().plusMinutes(plotConfiguration.getIrrigationRate()));

			plot.setPlotConfigurations(Set.of(plotConfiguration));
			
			plotRepository.save(plot);
	}
	
	private void loadTestCase2Data() {
		Plot plot = new Plot();
		
		plot.setLocation("Patna,kankarbagh");
		plot.setArea(80);
		plot.setOwnerName("Mayank karla");
		plot.setLastIrragtionDate(LocalDateTime.now());
		
		//plot sensor
		PlotSensor plotSensor = new PlotSensor();
		plotSensor.setAvailable(false);
		plot.setPlotSensor(plotSensor);
		
		//plot configurations
		PlotConfiguration plotConfiguration = new PlotConfiguration();
		Crop crop = cropRepository.findByName("ladyfinger").get();
		plotConfiguration.setCrop(crop);
		plotConfiguration.setPlot(plot);
		plotConfiguration.setCurrentConfig(true);
		plotConfiguration.setIrrigationRate(crop.getIrrigationRate());
		plotConfiguration.setWaterAmount(crop.getWaterAmountUnit()*plot.getArea());
		
		plot.setNextIrragtionDate(LocalDateTime.now().plusMinutes(plotConfiguration.getIrrigationRate()));
		
		plot.setPlotConfigurations(Set.of(plotConfiguration));
		
		plotRepository.save(plot);
	}

	private void loadTestCase3Data() {
		
		Plot plot = new Plot();
		
		plot.setLocation("Patna,danapur");
		plot.setArea(60);
		plot.setOwnerName("Meena");
		plot.setLastIrragtionDate(LocalDateTime.now());
		
		//plot sensor
		PlotSensor plotSensor = new PlotSensor();
		plotSensor.setAvailable(true);
		plot.setPlotSensor(plotSensor);
		
		//plot configurations
		PlotConfiguration plotConfiguration = new PlotConfiguration();
		Crop crop = cropRepository.findByName("gram").get();
		plotConfiguration.setCrop(crop);
		plotConfiguration.setPlot(plot);
		plotConfiguration.setCurrentConfig(true);
		plotConfiguration.setIrrigationRate(crop.getIrrigationRate());
		plotConfiguration.setWaterAmount(crop.getWaterAmountUnit()*plot.getArea());
		
		plot.setNextIrragtionDate(LocalDateTime.now().plusMinutes(plotConfiguration.getIrrigationRate()));
		
		plot.setPlotConfigurations(Set.of(plotConfiguration));
		
		//plot irrigation transaction history
		IrrigationTransaction irrigationTransaction = new IrrigationTransaction();
		irrigationTransaction.setPlot(plot);
		irrigationTransaction.setIrragtionDate(LocalDateTime.now().minusMinutes(5));
		irrigationTransaction.setStatus(IrrigationTransactionStatus.FAILED);
		irrigationTransaction.setTrials(2);
		
		plot.setIrrigationTransactions(Set.of(irrigationTransaction));
		
		plotRepository.save(plot);
		
	}
}
