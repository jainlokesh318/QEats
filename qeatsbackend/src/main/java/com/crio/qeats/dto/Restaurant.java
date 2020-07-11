
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: CRIO_TASK_MODULE_SERIALIZATION
//  Implement Restaurant class.
// Complete the class such that it produces the following JSON during serialization.
// {
//  "restaurantId": "10",
//  "name": "A2B",
//  "city": "Hsr Layout",
//  "imageUrl": "www.google.com",
//  "latitude": 20.027,
//  "longitude": 30.0,
//  "opensAt": "18:00",
//  "closesAt": "23:00",
//  "attributes": [
//    "Tamil",
//    "South Indian"
//  ]
// }

@Data
@NoArgsConstructor
public class Restaurant {

  @JsonIgnore @Getter @Setter private String id;
  @Getter @Setter private String restaurantId;
  @Getter @Setter private String name;
  @Getter @Setter private String city;
  @Getter @Setter private String imageUrl;
  @Getter @Setter private Double latitude;
  @Getter @Setter private Double longitude;
  @Getter @Setter private String opensAt;
  @Getter @Setter private String closesAt;
  @Getter @Setter private List<String> attributes;

  public Object getRestaurantId() {
    return restaurantId;
  }
}
