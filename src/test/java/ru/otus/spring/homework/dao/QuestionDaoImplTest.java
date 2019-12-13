package ru.otus.spring.homework.dao;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;
import ru.otus.spring.homework.domain.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@DisplayName("проверка имплементации слоя данных")
public class QuestionDaoImplTest {

    @DisplayName("ресурс присутствует и корректно парсится")
    @Test
    void shouldCorrectParseObject() throws FileNotFoundException {

        CSVReader reader= new CSVReader(new FileReader(ClassLoader.getSystemResource("csv/ru_questions.csv").getFile()), ';');
        assertEquals(Boolean.FALSE, StringUtils.isEmpty(reader));

        ColumnPositionMappingStrategy<Question> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Question.class);
        strategy.setColumnMapping("question", "variant_1", "variant_2", "variant_3", "answer");
        CsvToBean<Question> csvToBean = new CsvToBean<>();
        List<Question> questionList = new ArrayList<>(csvToBean.parse(strategy,reader));

        assertEquals(Boolean.TRUE, Question.class.isInstance(questionList.get(0)));
    }
}
