package com.caps.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caps.dao.UserDao;
import com.caps.entity.College;
import com.caps.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserDao dao;
	@Autowired
	private ICollegeService collegeService;

	@Override
	public boolean register(User user) {
		long phoneNo = user.getPhoneNo();
		boolean existingUser = dao.existsById(phoneNo);

		if (existingUser) {
			return false;
		} else {

			user.setPassword(toEncode(user.getPassword()));
			dao.save(user);
			return true;

		}
	}

	public static String toEncode(String message) {
		return Base64.getEncoder().encodeToString(message.getBytes());
	}

	@Override
	public boolean login(long phoneNo, String password) {
		boolean existingUser = dao.existsById(phoneNo);

		if (existingUser) {
			User user = dao.getOne(phoneNo);
			String userPassword = toDecode(user.getPassword());

			if (userPassword.equals(password))
				return true;
			else
				return false;
		} else
			return false;

	}

	@Override
	public User getUserName(long phoneNo) {

		User user = dao.findById(phoneNo).get();

		return user;

	}

	public static String toDecode(String message) {
		byte[] decodedBytes = Base64.getDecoder().decode(message);
		return new String(decodedBytes);
	}

	@Override
	public boolean setPassword(long phoneNo, String securityQuestion, String answer, String password) {
		boolean existingUser = dao.existsById(phoneNo);
		if (existingUser) {
			User user = dao.getOne(phoneNo);

			if (user.getSecurityQuestion().equals(securityQuestion) && user.getAnswer().equalsIgnoreCase(answer)) {
				user.setPassword(toEncode(password));

				dao.save(user);
				return true;

			} else
				return false;

		} else
			return false;

	}

	@Override
	public List<College> viewPredictedColleges(long phoneNo, String branch) {
		// TODO Auto-generated method stub
		List<College> college = collegeService.getAllColleges();
		List<College> predictedcolleges = new ArrayList();

		for (int i = 0; i < college.size(); i++) {
			User u = dao.findById(phoneNo).get();

			College c = college.get(i);
			HashMap<String, Double> obj = c.getBranchCutoff();
			for (String keys : obj.keySet()) {
				Double d = obj.get(keys);
				if (d <= (u.getMarks()) && keys.equalsIgnoreCase(branch)) {

					predictedcolleges.add(c);

				}

			}

		}

		return predictedcolleges;
	}

	@Override
	public List<College> getAllColleges() {
		return collegeService.getAllColleges();
	}

	@Override
	public User getProfile(long phoneNo) {
		boolean existingUser = dao.existsById(phoneNo);
		if (existingUser) {
			User user = dao.findById(phoneNo).get();
			System.out.println(user);
			return user;

		} else
			return null;

	}

	@Override
	public boolean updateProfile(User user) {
		long phoneNo = user.getPhoneNo();
		boolean existingUser = dao.existsById(phoneNo);

		if (existingUser) {
			User olduser = dao.getOne(phoneNo);
			user.setPassword(olduser.getPassword());
			dao.save(user);
			return true;

		} else
			return false;
	}

	@Override
	public List<College> viewCollegesBasedOnMarks(long phoneNo) {
		List<College> college = collegeService.getAllColleges();
		List<College> predictedcolleges = new ArrayList();
		for (int i = 0; i < college.size(); i++) {
			User u = dao.findById(phoneNo).get();

			College c = college.get(i);
			HashMap<String, Double> obj = c.getBranchCutoff();
			HashMap<String, Double> obj2 = new HashMap<>();
			HashMap<String, Double> obj3 = new HashMap<>();
			for (String keys : obj.keySet()) {
				Double d = obj.get(keys);
				if (d <= (u.getMarks())) {
					obj2.put(keys, d);
					System.out.println(obj2);

				} else {

					obj3.put(keys, d);

				}
			}
			if (!obj2.isEmpty()) {
				c.setBranchCutoff(obj2);
				predictedcolleges.add(c);
			}

		}
		return predictedcolleges;
	}

	@Override
	public List<College> getByAll(String state, String city, String branch) {
		List<College> college = collegeService.getAllColleges();
		List<College> predictedcolleges = new ArrayList();

		for (int i = 0; i < college.size(); i++) {

			College c = college.get(i);
			HashMap<String, Double> obj = c.getBranchCutoff();
			HashMap<String, Double> obj1 = new HashMap<>();
			for (String keys : obj.keySet()) {
				if (c.getState().equalsIgnoreCase(state) && c.getCity().equalsIgnoreCase(city)
						&& keys.equalsIgnoreCase(branch)) {
					Double d = obj.get(keys);
					obj1.put(keys, d);
					c.setBranchCutoff(obj1);
					predictedcolleges.add(c);

				}

			}

		}

		return predictedcolleges;

	}

	@Override
	public List<College> getBystateandcity(String state, String city) {
		List<College> college = collegeService.getAllColleges();
		List<College> predictedcolleges = new ArrayList();

		for (int i = 0; i < college.size(); i++) {

			College c = college.get(i);

			if (c.getState().equalsIgnoreCase(state) && c.getCity().equalsIgnoreCase(city)) {
				predictedcolleges.add(c);

			}

		}

		return predictedcolleges;
	}

	@Override
	public List<College> getBystateandbranch(String state, String branch) {
		List<College> college = collegeService.getAllColleges();
		List<College> predictedcolleges = new ArrayList();

		for (int i = 0; i < college.size(); i++) {

			College c = college.get(i);
			HashMap<String, Double> obj = c.getBranchCutoff();
			HashMap<String, Double> obj1 = new HashMap<>();
			for (String keys : obj.keySet()) {
				if (c.getState().equalsIgnoreCase(state) && keys.equalsIgnoreCase(branch)) {
					Double d = obj.get(keys);
					obj1.put(keys, d);
					c.setBranchCutoff(obj1);
					predictedcolleges.add(c);

				}

			}

		}

		return predictedcolleges;
	}

	@Override
	public List<College> getBycityandbranch(String city, String branch) {
		List<College> college = collegeService.getAllColleges();
		List<College> predictedcolleges = new ArrayList();

		for (int i = 0; i < college.size(); i++) {

			College c = college.get(i);
			HashMap<String, Double> obj = c.getBranchCutoff();
			HashMap<String, Double> obj1 = new HashMap<>();
			for (String keys : obj.keySet()) {
				if (c.getCity().equalsIgnoreCase(city) && keys.equalsIgnoreCase(branch)) {
					Double d = obj.get(keys);
					obj1.put(keys, d);
					c.setBranchCutoff(obj1);
					predictedcolleges.add(c);

				}

			}

		}

		return predictedcolleges;
	}

	@Override
	public List<College> getByState(String state) {
		List<College> college = collegeService.getAllColleges();
		List<College> predictedcolleges = new ArrayList();

		for (int i = 0; i < college.size(); i++) {

			College c = college.get(i);

			if (c.getState().equalsIgnoreCase(state)) {
				predictedcolleges.add(c);

			}

		}

		return predictedcolleges;

	}

	@Override
	public List<College> getByCity(String city) {
		List<College> college = collegeService.getAllColleges();
		List<College> predictedcolleges = new ArrayList();

		for (int i = 0; i < college.size(); i++) {

			College c = college.get(i);

			if (c.getCity().equalsIgnoreCase(city)) {
				predictedcolleges.add(c);

			}

		}

		return predictedcolleges;
	}

	@Override
	public List<College> getByBranch(String branch) {
		List<College> college = collegeService.getAllColleges();
		List<College> predictedcolleges = new ArrayList();

		for (int i = 0; i < college.size(); i++) {

			College c = college.get(i);
			HashMap<String, Double> obj = c.getBranchCutoff();
			HashMap<String, Double> obj1 = new HashMap<>();
			for (String keys : obj.keySet()) {
				if (keys.equalsIgnoreCase(branch)) {
					Double d = obj.get(keys);
					obj1.put(keys, d);
					c.setBranchCutoff(obj1);
					predictedcolleges.add(c);

				}

			}

		}

		return predictedcolleges;
	}

}
