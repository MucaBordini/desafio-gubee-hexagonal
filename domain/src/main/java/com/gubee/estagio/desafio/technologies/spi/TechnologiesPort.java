package com.gubee.estagio.desafio.technologies.spi;

import com.gubee.estagio.desafio.technologies.Technology;

import java.util.List;

public interface TechnologiesPort {

    Technology save (Technology technology);

    List<Technology> findAllTechnologies();

}
