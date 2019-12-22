package ru.otus.spring.homework;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import ru.otus.spring.homework.domain.Dialog;
import ru.otus.spring.homework.domain.Question;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MainTests {

	@DisplayName("поднимается контекст")
	@Test
	void contextLoads() {
	}

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

	@DisplayName("Корректное создание объекта Question")
	@Test
	void shouldCanCreateQuestionObject() {
		Question question = new Question("вопрос", "вариант_ответа_1", "вариант_ответа_2","вариант_ответа_3", 3);

		assertEquals("вопрос",question.getQuestion());
		assertEquals(3, question.getAnswer());

	}

	@DisplayName("Корректное создание объекта Dialog, проверка наличич ресурсов")
	@Test
	void shouldCanCreateDialogObject() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF8");
		messageSource.setBasename("messages_ru_RU");
		Locale locale = new Locale("ru", "RU");

		Dialog dialog = new Dialog(messageSource.getMessage("greeting", new String[]{}, locale),
				messageSource.getMessage("choosing", new String[]{}, locale),
				messageSource.getMessage("variant", new String[]{}, locale),
				messageSource.getMessage("answer.true", new String[]{}, locale),
				messageSource.getMessage("answer.false", new String[]{}, locale),
				messageSource.getMessage("answer.pass", new String[]{}, locale));

		System.out.println("тестирование отображения приветствия: " + dialog.getGreeting());
	}


}
