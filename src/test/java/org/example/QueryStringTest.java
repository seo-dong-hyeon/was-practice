package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {

    @Test
    void create(){
        QueryString queryString = new QueryString("operand1", "11");
        assertThat(queryString).isNotNull();
    }
}
