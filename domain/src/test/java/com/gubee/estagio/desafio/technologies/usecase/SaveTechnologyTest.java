package com.gubee.estagio.desafio.technologies.usecase;

import com.gubee.estagio.desafio.technologies.Technology;
import com.gubee.estagio.desafio.technologies.api.ListTechnologies;
import com.gubee.estagio.desafio.technologies.api.SaveTechnology;
import com.gubee.estagio.desafio.technologies.spi.TechnologiesPort;
import com.gubee.estagio.desafio.technologies.spi.stub.InMemoryTechnologies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;

import static org.junit.Assert.*;

public class SaveTechnologyTest {

    private ListTechnologies listTechUseCase;

    private SaveTechnology saveTechnologyUseCase;

    @BeforeEach
    void setUp() {
        TechnologiesPort technologiesPort = new InMemoryTechnologies();
        listTechUseCase = new ListTechnologiesImpl(technologiesPort);
        saveTechnologyUseCase = new SaveTechnologyImpl(technologiesPort);
    }

    @Test
    void should_save_technology(){
        //given
        var tgtMkt = Collections.singletonList("LOJA FISICA");
        var stk = Collections.singletonList("JAVA");

        Technology technologyTest = Technology.builder()
                .id("1")
                .productName("Example Product")
                .description("Example for testing")
                .targetMarket(tgtMkt)
                .stack(stk)
                .build();

        saveTechnologyUseCase.save(technologyTest);

        //when
        var listReturned = listTechUseCase.findAllTechnologies();

        var isEquals = technologyTest.equals(listReturned.get(1));

        //then
        assertTrue(isEquals);
    }

}
