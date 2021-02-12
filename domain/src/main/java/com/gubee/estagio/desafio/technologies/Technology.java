package com.gubee.estagio.desafio.technologies;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Technology {

    private String id;
    private String productName;
    private String description;
    private List<String> targetMarket;
    private List<String> stack;

}
