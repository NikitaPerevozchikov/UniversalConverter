package main;

import main.model.Index;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class ListGeneration {
    private static HashMap<String, HashMap<String, Index>> convertList = new HashMap<>();

    public static HashMap<String, HashMap<String, Index>> getConvertList() {
        return convertList;
    }

    public static void createListLineConvert(Path path) {
        List<String> listLineConverts = null;
        try {
            listLineConverts = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (listLineConverts != null) {
            if (path.toString().endsWith(".csv")) {
                ListGeneration.generationHash(listLineConverts);
            }
        }
    }

    private static void generationHash(List<String> listLineConverts) {
        listLineConverts.stream()
                .map(e -> e.split(","))
                .filter(e -> e.length == 3)
                .forEach(e -> {
                    if (!convertList.containsKey(e[0])) {
                        convertList.put(e[0], new HashMap<>());
                    }
                    if (!convertList.containsKey(e[1])) {
                        convertList.put(e[1], new HashMap<>());
                    }
                    if (convertList.containsKey(e[0])) {
                        convertList.get(e[0]).put(e[1], new Index(Double.parseDouble(e[2]), 1.0));
                    }
                    if (convertList.containsKey(e[1])) {
                        convertList.get(e[1]).put(e[0], new Index(1.0, Double.parseDouble(e[2])));
                    }
                });
    }
}
