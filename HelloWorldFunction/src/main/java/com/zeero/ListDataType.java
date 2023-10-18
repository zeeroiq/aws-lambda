package com.zeero;

import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.reflect.Modifier.TRANSIENT;

public class ListDataType {

    public List<Integer> getSampleScore(List<String> names) {
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("AB",  80);
        studentScores.put("BC",  90);
        studentScores.put("CD",  92);
        studentScores.put("DE",  95);

        return names
                .parallelStream()
                .map(studentScores::get)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public void addStudentsAndScores(Map<String, Integer> nameAndScoreMap) {
        String parsedName2ScoreMap = new GsonBuilder()
                .excludeFieldsWithModifiers(TRANSIENT)
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create()
                .toJson(nameAndScoreMap);
        System.out.println(parsedName2ScoreMap);
    }
}
