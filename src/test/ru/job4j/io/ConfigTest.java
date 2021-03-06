package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ConfigTest {


    @Test
    public void whenPairWithoutComment() {
        String path = "./src/data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name "), is(" Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithEmptyStrings() {
        String path = "./src/data/pair_with_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("text"), is("the file with the comment and empty strings"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenDoesntConformTemplate() {
        String path = "./src/data/template_violation.properties";
        Config config = new Config(path);
        config.load();
    }
}