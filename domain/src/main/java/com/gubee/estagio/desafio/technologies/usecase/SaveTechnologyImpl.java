package com.gubee.estagio.desafio.technologies.usecase;

import com.gubee.estagio.desafio.technologies.Technology;
import com.gubee.estagio.desafio.technologies.api.SaveTechnology;
import com.gubee.estagio.desafio.technologies.spi.TechnologiesPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveTechnologyImpl implements SaveTechnology {

    private final TechnologiesPort technologiesPort;

    @Override
    public Technology save(Technology technology) {
        return technologiesPort.save(technology);
    }
}
