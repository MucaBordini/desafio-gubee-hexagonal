package com.gubee.estagio.desafio.technologies.usecase;

import com.gubee.estagio.desafio.technologies.Technology;
import com.gubee.estagio.desafio.technologies.api.ListTechnologies;
import com.gubee.estagio.desafio.technologies.api.SaveTechnology;
import com.gubee.estagio.desafio.technologies.spi.TechnologiesPort;

import com.gubee.estagio.desafio.technologies.spi.stub.InMemoryTechnologies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;

public class ListTechnologiesTest {

    private ListTechnologies listTechUseCase;

    private SaveTechnology saveTechnologyUseCase;

    @BeforeEach
    void setUp() {
        TechnologiesPort technologiesPort = new InMemoryTechnologies();
        listTechUseCase = new ListTechnologiesImpl(technologiesPort);
        saveTechnologyUseCase = new SaveTechnologyImpl(technologiesPort);
    }

    @Test
    void should_list_technologies() {
        //given
        var tgtMkt = Collections.singletonList("LOJA FISICA");
        var stk = Collections.singletonList("JAVA");

        Technology technologyTest =
                new Technology("1", "Example Product", "Example for testing", tgtMkt, stk);

        var tgtMkt2 = Collections.singletonList("ECOMMERCE");
        var stk2 = Collections.singletonList("NODEJS");

        Technology technologyTest2 =
                new Technology("2", "Example Product", "Example for testing", tgtMkt2, stk2);

        saveTechnologyUseCase.save(technologyTest);
        saveTechnologyUseCase.save(technologyTest2);

        //when
        var listFromUseCase = listTechUseCase.findAllTechnologies();

        //then
        assertEquals(2, listFromUseCase.size());

    }
}
