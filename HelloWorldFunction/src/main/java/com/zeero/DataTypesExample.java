package com.zeero;

import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zeero.pojo.Patient;
import com.zeero.pojo.TestsData;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.reflect.Modifier.TRANSIENT;

public class DataTypesExample {

    Gson gson = new GsonBuilder()
            .excludeFieldsWithModifiers(TRANSIENT)
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();

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



         String parsedName2ScoreMap = gson.toJson(student2scoreMap);
        System.out.println("Student 2 Score map :\n" + parsedName2ScoreMap);
        return student2scoreMap;
    }

    public TestsData getPatientTestsData(Patient patient) {
        System.out.println("Patient Details: \n" + patient);

        TestsData testsData = new TestsData();
        testsData.setBp("80/120");
        testsData.setHeartRate("190 tpm");

        return testsData;
    }

    public void testOutputStream(InputStream input, OutputStream output, Context context) throws IOException {
        int data;
        while ((data = input.read()) != -1) {
            output.write(Character.toLowerCase(data));
        }
        System.out.println("Remaining Time In Millis - " + context.getRemainingTimeInMillis());
        System.out.println("Function Name - " + context.getFunctionName());
        System.out.println("Function Version - " + context.getFunctionVersion());
        System.out.println("Invoked Function ARN - " + context.getInvokedFunctionArn());
        System.out.println("Memory Limit In MB - " + context.getMemoryLimitInMB());
        System.out.println("AWS request ID - " + context.getAwsRequestId());
        System.out.println("Log Group Name - " + context.getLogGroupName());
        System.out.println("Log Stream Name - " + context.getLogStreamName());
        System.out.println("Identity - " + context.getIdentity());
        System.out.println("Client Context - " + context.getClientContext());
        System.out.println("Logger - " + context.getLogger());
        context.getLogger().log("Context Object info\n");
        context.getLogger().log(gson.toJson(context));
        System.out.println("\n");

    }
}
