package com.caps.service;

import com.caps.entity.College;
import com.caps.entity.FeedBack;

import java.util.List;

import org.springframework.stereotype.Service;

public interface IFeedBackService {
    public boolean giveFeedback(FeedBack feedBack);

	public List<FeedBack> getFeedback();
}
