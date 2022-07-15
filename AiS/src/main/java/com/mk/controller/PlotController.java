package com.mk.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.controller.payload.PlotDto;
import com.mk.data.model.Plot;
import com.mk.service.PlotService;

@RestController
@RequestMapping("/plot")
@CrossOrigin(origins = "*")
public class PlotController {

	@Autowired
	PlotService plotService;

	@GetMapping()
	private List<Plot> getAllPlots() {
		return plotService.getAllPlots();
	}

	@GetMapping("/{id}")
	private Plot getPlot(@PathVariable("id") int id) {
		return plotService.getPlotById(id);
	}
	
	/**
	 * Request parameter
	 * @param {"location":"Jamui,Lakshamipur","area":110,"ownerName":"Nitin pathak","plotConfiguration":{"cropId":2,"waterAmountUnit":100,"irrigationRate":2,"waterAmount":7000}}
	 */

	@PostMapping
	public ResponseEntity<Plot> addNewPlot(@RequestBody PlotDto plotDto) {
		return ResponseEntity.ok(plotService.addNewPlot(plotDto));
	}

	/**
	 * Request parameter
	 * @param {"id":5,"location":"Jamui,Sikandra","area":90,"ownerName":"Dilip kumar","plotConfiguration":{"id":3,"name":"gram","irrigationRate":2,"waterAmountUnit":300,"irrigationRate":2,"waterAmount":27000,"currentConfig":true}}
	 */

	@PatchMapping("/{id}")
	public ResponseEntity<Plot> editPlot(@PathVariable("id") int id, @RequestBody PlotDto plotDto) {
		plotDto.setId(id);
		return ResponseEntity.ok(plotService.editPlot(plotDto));
	}

}
