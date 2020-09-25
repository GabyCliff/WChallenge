package com.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wchallenge.helpers.ViewRouteHelper;
import com.wchallenge.model.PhotoModel;
import com.wchallenge.service.IPhotoService;

@Controller
@RequestMapping("/photos")
public class PhotoController {
	
	@Autowired
	private IPhotoService photoService;
	
	@GetMapping("")
    public ModelAndView getPhotos(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.PHOTO_INDEX);
        mAV.addObject("photos", photoService.getAll());
        return mAV;
    }
	
	@GetMapping("/{id}")
	public List<PhotoModel> getPhotoByAlbum(@PathVariable("id") long id) {
		List<PhotoModel> photos = new ArrayList<PhotoModel>();
		photos = photoService.findByAlbum(id);
		return photos;
	}

}
