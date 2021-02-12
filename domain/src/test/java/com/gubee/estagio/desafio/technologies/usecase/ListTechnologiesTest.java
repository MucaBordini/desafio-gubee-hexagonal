package com.gubee.estagio.desafio.technologies.usecase;

import com.gubee.estagio.desafio.technologies.Technology;
import com.gubee.estagio.desafio.technologies.api.ListTechnologies;
import com.gubee.estagio.desafio.technologies.api.SaveTechnology;
import com.gubee.estagio.desafio.technologies.spi.TechnologiesPort;

import com.gubee.estagio.desafio.technologies.spi.stub.InMemoryTechnologies;
import org.mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

public class ListTechnologiesTest {

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
    void should_list_technologies() {
        //given
        var tgtMkt = Arrays.asList("LOJA FISICA");
        var stk = Arrays.asList("JAVA");

        Technology technologyTest =
                new Technology("1", "Example Product", "Example for testing", tgtMkt, stk);

        saveTechnologyUseCase.save(technologyTest);

        //when
        var listFromUseCase = listTechUseCase.findAllTechnologies();

        //then
        assertEquals(1, listFromUseCase.size());

    }
}
