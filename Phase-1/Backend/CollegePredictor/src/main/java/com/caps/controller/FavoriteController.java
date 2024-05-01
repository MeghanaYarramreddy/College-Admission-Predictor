package com.caps.controller;


import com.caps.entity.Favorites;
import com.caps.service.IFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class FavoriteController {

    @Autowired
    private IFavoriteService favoriteService;

    @PostMapping(value = "/addFavorite", consumes = "application/json")
    public ResponseEntity<Boolean> addFavoriteCollege(@RequestBody Favorites favorites) {

        return ResponseEntity.status(HttpStatus.CREATED).body(favoriteService.addFavoriteCollege(favorites));
    }

    @GetMapping(value = "/getAllFavcolleges/{userId}")
    public List<Favorites> getAllFavCollegesById(@PathVariable Long userId) {

        return favoriteService.getAllFavCollegesById(userId);
    }

    @DeleteMapping(value = "/deleteFavCollege/{collegeCode}")
    public void deleteFavCollege(@PathVariable String collegeCode) {

        favoriteService.deleteById(collegeCode);
    }
}
