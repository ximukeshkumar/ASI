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
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
public class PlotController {
	
	@Autowired
	PlotService plotService;  
	
	@GetMapping()  
	private List<Plot> getAllPlots()   
	{
		System.out.println("Hi this is Plot controller...");
		return plotService.getAllPlots();  
	}
	
	@GetMapping("/{id}")  
	private Plot getPlot(@PathVariable("id") int id)   
	{  
		return plotService.getPlotById(id);
	}
	
	@PostMapping
    public ResponseEntity<Plot> addNewPlot(@RequestBody PlotDto plotDto) {
        return ResponseEntity.ok(plotService.addNewPlot(plotDto));
    }
	
	@PatchMapping("/{id}")
    public ResponseEntity<Plot> editPlot(@PathVariable("id") int id,@RequestBody PlotDto plotDto) {
		plotDto.setId(id);
        return ResponseEntity.ok(plotService.editPlot(plotDto));
    }

}
