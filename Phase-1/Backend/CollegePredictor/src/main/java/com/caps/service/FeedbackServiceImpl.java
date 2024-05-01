package com.caps.service;

import com.caps.dao.FeedBackDao;
import com.caps.dao.UserDao;
import com.caps.entity.College;
import com.caps.entity.FeedBack;
import com.caps.entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements IFeedBackService {

    @Autowired
    FeedBackDao feedBackDao;

    @Autowired
    UserDao userDao;

    User user;

    @Override
    public boolean giveFeedback(FeedBack feedBack) {

        long phoneNo = feedBack.getPhoneNo();
        boolean existingUser = userDao.existsById(phoneNo);
        User u=userDao.findById(phoneNo).get();
        feedBack.setUserEmail(u.getEmail());
        feedBack.setUserName(u.getName());
        if(feedBack.getFeedback()==null){
        	feedBack.setFeedback("Ok");
        }
        if (!existingUser) {
            return false;
        }

        feedBackDao.save(feedBack);
        return true;
    }

	@Override
	public List<FeedBack> getFeedback() {
		return feedBackDao.findAll();
	}
}
