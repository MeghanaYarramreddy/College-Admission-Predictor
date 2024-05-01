package com.caps.dao;

import com.caps.entity.College;
import com.caps.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteDao extends JpaRepository<Favorites, String> {

    List<Favorites> findAllByUserId(Long userId);
}
