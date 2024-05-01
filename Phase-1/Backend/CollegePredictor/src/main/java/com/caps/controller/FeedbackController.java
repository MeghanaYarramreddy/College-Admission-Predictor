package com.caps.controller;

import com.caps.entity.FeedBack;
import com.caps.service.IFeedBackService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class FeedbackController {

    @Autowired
    IFeedBackService feedBackService;

    @PostMapping(value="/feedback" , consumes = "application/json")
    public ResponseEntity<Boolean> giveFeedback(@RequestBody FeedBack feedBack)
    {

        return ResponseEntity.status(HttpStatus.CREATED).body(feedBackService.giveFeedback(feedBack));
    }
    @GetMapping(value = "/getFeedback")
	public List<FeedBack> getFeedback() {
		return feedBackService.getFeedback();

	}

}
