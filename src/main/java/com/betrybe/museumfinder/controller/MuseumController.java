package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * MuseumController class.
 */

@RestController
@RequestMapping("/museums")
public class MuseumController {

  @Autowired
  private MuseumServiceInterface museumService;

  /**
   * Method Post CreateMuseum.
   */

  @PostMapping
  public ResponseEntity<MuseumDto> createMuseum(@RequestBody MuseumCreationDto museumCreationDto) {
    Museum newMuseum = ModelDtoConverter.dtoToModel(museumCreationDto);
    Museum createdMuseum = museumService.createMuseum(newMuseum);
    MuseumDto createdMuseumDto = ModelDtoConverter.modelToDto(createdMuseum);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdMuseumDto);
  }
  
  /**
   * Method GET /closest.
   */

  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> getClosestMuseum(@RequestParam("lat") Double latitude,
      @RequestParam("lng") Double longitude, @RequestParam("max_dist_km") Double maxDistanceKm) {

    Coordinate coordinate = new Coordinate(latitude, longitude);


    Museum closestMuseum = museumService.getClosestMuseum(coordinate, maxDistanceKm);


    if (closestMuseum == null) {
      return ResponseEntity.notFound().build();
    }


    MuseumDto closestMuseumDto = ModelDtoConverter.modelToDto(closestMuseum);
    return ResponseEntity.ok(closestMuseumDto);
  }
}

