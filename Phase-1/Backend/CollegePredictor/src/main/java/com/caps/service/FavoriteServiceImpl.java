package com.caps.service;

import com.caps.dao.CollegeDao;
import com.caps.dao.FavoriteDao;
import com.caps.entity.Favorites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FavoriteServiceImpl implements IFavoriteService {

    @Autowired
    private FavoriteDao favoriteDao;

    @Autowired
    private CollegeDao collegeDao;

    @Override
    public boolean addFavoriteCollege(Favorites favorites) {
        boolean existedCollege = collegeDao.existsById(favorites.getCollegeCode());

        if (!existedCollege == false) {
            return false;
        }
        favoriteDao.save(favorites);
        return true;
    }

    @Override
    public List<Favorites> getAllFavCollegesById(Long userId) {

        return favoriteDao.findAllByUserId(userId);
    }

    @Override
    public void deleteById(String collegeCode) {

        favoriteDao.deleteById(collegeCode);
    }
}
