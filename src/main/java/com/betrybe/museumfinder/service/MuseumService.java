package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Museum.
 */

@Service
public class MuseumService implements MuseumServiceInterface {

  private final MuseumFakeDatabase data;

  @Autowired
  public MuseumService(MuseumFakeDatabase data) {
    this.data = data;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    if (museum == null) {
      throw new IllegalArgumentException("Museum object cannot be null.");
    }

    Coordinate coordinate = museum.getCoordinate();
    if (coordinate == null || !CoordinateUtil.isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException("Invalid coordinate provided.");
    }

    return data.saveMuseum(museum);
  }


  @Override
  public Museum getMuseum(Long id) {
    return null;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    return null;
  }



}
