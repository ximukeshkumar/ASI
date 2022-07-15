package com.mk.service;

import java.util.List;

import com.mk.data.model.Crop;

public interface CropService extends CommonService{
	
	List<Crop> getAllCropss();
	
	Crop getCropById(int id);

}
