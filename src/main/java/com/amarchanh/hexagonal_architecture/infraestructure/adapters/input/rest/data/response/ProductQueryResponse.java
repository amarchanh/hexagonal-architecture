package com.amarchanh.hexagonal_architecture.infraestructure.adapters.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductQueryResponse {

    private Long id;

    private String name;

    private String description;

}
