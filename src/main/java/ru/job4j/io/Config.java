package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                if (line.isEmpty()) {
                    continue;
                }
                if (line.startsWith("#")) {
                    continue;
                }
                String[] arrayLine = line.split("=", 2);
                if (arrayLine.length != 2 || arrayLine[0].isEmpty() || arrayLine[1].isEmpty()) {
                    throw new IllegalArgumentException(String.format("Invalid line: %s", line));
                }
                values.put(arrayLine[0], arrayLine[1]);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("./data/app.properties"));
        System.out.println(new Config("./data/pair_with_comments.properties"));
        System.out.println(new Config("./data/template_violation.properties"));
    }
}
