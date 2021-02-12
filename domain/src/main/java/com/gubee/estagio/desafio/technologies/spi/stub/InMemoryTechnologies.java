package com.gubee.estagio.desafio.technologies.spi.stub;

import com.gubee.estagio.desafio.technologies.Technology;
import com.gubee.estagio.desafio.technologies.spi.TechnologiesPort;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTechnologies implements TechnologiesPort {

    private final List<Technology> list = new ArrayList<>();

    @Override
    public Technology save(Technology technology) {
        list.add(technology);
        return technology;
    }

    @Override
    public List<Technology> findAllTechnologies() {
        var list = this.list;
        return list;
    }
}
