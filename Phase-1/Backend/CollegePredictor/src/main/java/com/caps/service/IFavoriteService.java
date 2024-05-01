package com.caps.service;

import com.caps.entity.Favorites;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IFavoriteService {

    public boolean addFavoriteCollege(Favorites favorites);

    public List<Favorites> getAllFavCollegesById(Long userId);

    void deleteById(String collegeCode);
}
