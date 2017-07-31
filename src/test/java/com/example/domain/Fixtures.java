package com.example.domain;

/**
 * Utilities for constructing test fixtures.
 *
 * @author simon
 */
public final class Fixtures {

    public static Country createCountry(){
        return new Country("pt", "Portugal");
    }

    public static Language createLanguage(){
        return new Language("pt", "Portuguese");
    }
}
