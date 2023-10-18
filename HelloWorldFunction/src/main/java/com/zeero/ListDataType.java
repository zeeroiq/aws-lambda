package com.zeero;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
}
