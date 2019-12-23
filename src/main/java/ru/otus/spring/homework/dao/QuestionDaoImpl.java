package ru.otus.spring.homework.dao;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.otus.spring.homework.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class QuestionDaoImpl implements QuestionDao {

    //демонстрация чтения из yaml-файла
    @Value("${path-RU-csv}")
    private String csvRuPath;

    @Value("${path-EN-csv}")
    private String csvEnPath;

    public Map<Question, Integer> getQuestions(int localeNumber) {
        return generateAnswerMap(localeNumber);
    }

    private String getPathToCsv(int localeNumber) {

        //демонстрация выбора локали
        switch (localeNumber) {
            case 1:
                return csvRuPath;
            case 2:
                return csvEnPath;
        }
        return null;
    }

    private List<Question> readQuestionsFromCsv(int localeNumber) throws URISyntaxException {
        String csvPath = getPathToCsv(localeNumber);

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(String.valueOf(Paths.get(ClassLoader.getSystemResource(csvPath).toURI()))), ';');

        } catch (IOException ie) {
            ie.printStackTrace();
        }

        ColumnPositionMappingStrategy<Question> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Question.class);
        //формат CSV-файла: вопрос, три варианта ответа, номер верного ответа
        strategy.setColumnMapping("question", "variant_1", "variant_2", "variant_3", "answer");

        CsvToBean<Question> csvToBean = new CsvToBean<>();
        return csvToBean.parse(strategy, reader);

    }

    private Map<Question, Integer> generateAnswerMap(int localeNumber) {

        List<Question> questionList = null;
        try {
            questionList = readQuestionsFromCsv(localeNumber);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Map<Question, Integer> questionMap = new HashMap<>();

        int counter = 0;
        for (Question question : questionList) {
            questionMap.put(questionList.get(counter), question.getAnswer());
            counter++;
        }

        return questionMap;

    }


}
