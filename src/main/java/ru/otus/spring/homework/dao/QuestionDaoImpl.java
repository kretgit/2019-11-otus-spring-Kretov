package ru.otus.spring.homework.dao;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import org.springframework.core.io.Resource;
import ru.otus.spring.homework.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDaoImpl implements QuestionDao {

    public Map getQuestions() {
        return generateAnswerMap();
    }

    private Resource resource;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }


    private List<Question> readQuestionsFromCsv() {

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(getResource().getFile()),';');

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

    private Map generateAnswerMap() {

        List<Question> questionList = readQuestionsFromCsv();
        Map<Question, Integer> questionMap = new HashMap<>();

        int counter = 0;
        for (Question question : questionList) {
            questionMap.put(questionList.get(counter), question.getAnswer());
            counter++;
        }

        return questionMap;

    }


}
