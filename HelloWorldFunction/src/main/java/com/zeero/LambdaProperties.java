package com.zeero;

import com.amazonaws.services.lambda.runtime.Context;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaProperties {
    public Map<String, List<Integer>> getStudentScores(Context context) throws InterruptedException {
        Thread.sleep(5000);

        Map<String, List<Integer>> student2scoreMap;
        student2scoreMap = new HashMap<>();
        student2scoreMap.put("AB", Arrays.asList(70, 80, 90));
        student2scoreMap.put("BC", Arrays.asList(70, 85, 90));
        student2scoreMap.put("CD", Arrays.asList(70, 80, 95));
        student2scoreMap.put("DE", Arrays.asList(75, 80, 90));



        String parsedName2ScoreMap = DataTypesExample.gson.toJson(student2scoreMap);
        context.getLogger().log("Student 2 Score map :\n" + parsedName2ScoreMap + "\n");
        return student2scoreMap;
    }
    public String readSystemProperties(Context context) throws InterruptedException {
        String lambdaEnvInfo = System.getenv("lambda_env_info");
        context.getLogger().log("Env property read from lambda prior to return - " + lambdaEnvInfo);
        return lambdaEnvInfo;
    }

}
