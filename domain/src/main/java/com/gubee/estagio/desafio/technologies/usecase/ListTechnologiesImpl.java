package com.gubee.estagio.desafio.technologies.usecase;

import com.gubee.estagio.desafio.technologies.Technology;
import com.gubee.estagio.desafio.technologies.api.ListTechnologies;
import com.gubee.estagio.desafio.technologies.spi.TechnologiesPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListTechnologiesImpl implements ListTechnologies {

    private final TechnologiesPort technologiesPort;

    @Override
    public List<Technology> findAllTechnologies() {
        return technologiesPort.findAllTechnologies();
    }
}
