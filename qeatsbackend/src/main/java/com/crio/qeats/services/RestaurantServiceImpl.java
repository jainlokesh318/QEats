
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.services;

import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.crio.qeats.repositoryservices.RestaurantRepositoryService;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RestaurantServiceImpl implements RestaurantService {

  private final Double peakHoursServingRadiusInKms = 3.0;
  private final Double normalHoursServingRadiusInKms = 5.0;
  @Autowired
  private RestaurantRepositoryService restaurantRepositoryService;


  // TODO: CRIO_TASK_MODULE_RESTAURANTSAPI - IgetRestaurantsRequest.latitude
  // mplement findAllRestaurantsCloseby.
  // Check RestaurantService.java file for the interface contract.
  @Override
  public GetRestaurantsResponse findAllRestaurantsCloseBy(
      GetRestaurantsRequest getRestaurantsRequest, LocalTime currentTime) {
      
    //interval 8-10 am
    LocalTime peakInterval1a = LocalTime.parse("07:59:59",
              DateTimeFormatter.ofPattern("HH:mm:ss"));
    LocalTime peakInterval1b = LocalTime.parse("10:00:01",
              DateTimeFormatter.ofPattern("HH:mm:ss"));
         
    //interval 1-2 pm
    LocalTime peakInterval2a = LocalTime.parse("12:59:59",
              DateTimeFormatter.ofPattern("HH:mm:ss"));
    LocalTime peakInterval2b = LocalTime.parse("14:00:01",
              DateTimeFormatter.ofPattern("HH:mm:ss"));
        
    //interval 7-9 pm    
    LocalTime peakInterval3a = LocalTime.parse("18:59:59",
              DateTimeFormatter.ofPattern("HH:mm:ss"));
    LocalTime peakInterval3b = LocalTime.parse("21:00:01",
              DateTimeFormatter.ofPattern("HH:mm:ss"));
          
    Double servingRadiusInKms = 5.0;

    if ((currentTime.isAfter(peakInterval1a) && currentTime.isBefore(peakInterval1b)) 
        || (currentTime.isAfter(peakInterval2a) && currentTime.isBefore(peakInterval2b)) 
        || (currentTime.isAfter(peakInterval3a) && currentTime.isBefore(peakInterval3b))) {
      servingRadiusInKms = 3.0;
    }

    List<Restaurant> restaurants = restaurantRepositoryService
        .findAllRestaurantsCloseBy(getRestaurantsRequest.latitude,
          getRestaurantsRequest.longitude, currentTime, servingRadiusInKms);

    GetRestaurantsResponse result = new GetRestaurantsResponse(restaurants);
    return result;
  }


}

