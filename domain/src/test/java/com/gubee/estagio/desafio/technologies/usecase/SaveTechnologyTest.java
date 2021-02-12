package com.gubee.estagio.desafio.technologies.usecase;

import com.gubee.estagio.desafio.technologies.Technology;
import com.gubee.estagio.desafio.technologies.api.ListTechnologies;
import com.gubee.estagio.desafio.technologies.api.SaveTechnology;
import com.gubee.estagio.desafio.technologies.spi.TechnologiesPort;
import com.gubee.estagio.desafio.technologies.spi.stub.InMemoryTechnologies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SaveTechnologyTest {

    private TechnologiesPort technologiesPort;

    private ListTechnologies listTechUseCase;

    private SaveTechnology saveTechnologyUseCase;

    @BeforeEach
    void setUp() {
        technologiesPort = new InMemoryTechnologies();
        listTechUseCase = new ListTechnologiesImpl(technologiesPort);
        saveTechnologyUseCase = new SaveTechnologyImpl(technologiesPort);
    }

    @Test
    void should_save_technology(){
        var tgtMkt = Arrays.asList("LOJA FISICA");
        var stk = Arrays.asList("JAVA");

        Technology technologyTest =
                new Technology("1", "Example Product", "Example for testing", tgtMkt, stk);

        saveTechnologyUseCase.save(technologyTest);

        var list = Arrays.asList(technologyTest);

        assertEquals(list, listTechUseCase.findAllTechnologies());
    }

}
