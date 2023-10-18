package com.zeero;

import com.google.gson.GsonBuilder;

import java.util.*;
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

    public Map<String, List<Integer>> getStudentScores() {

        Map<String, List<Integer>> student2scoreMap = new HashMap<>();
        student2scoreMap.put("AB", Arrays.asList(70, 80, 90));
        student2scoreMap.put("BC", Arrays.asList(70, 85, 90));
        student2scoreMap.put("CD", Arrays.asList(70, 80, 95));
        student2scoreMap.put("DE", Arrays.asList(75, 80, 90));


        String parsedName2ScoreMap = new GsonBuilder()
                .excludeFieldsWithModifiers(TRANSIENT)
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create()
                .toJson(student2scoreMap);
        System.out.println("Student 2 Score map :\n" + parsedName2ScoreMap);
        return student2scoreMap;
    }
}
