package org.example;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.example.HomeWork4.Main.triangleValues;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest{

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAllTests() {
        logger.info("Данное сообщение выходит перед каждым тестом");
    }

    @BeforeEach
    void initTest(){
        System.out.println("Тест запущен");
    }

//    @AfterEach
//    void afterTest(){
//        System.out.println("Тест завершен");
//    }

    @Test
    @DisplayName("Тест 1. Коректные данные сторон и результата")
    void correctData(){
        int a = triangleValues(3,4,5);
        assertThat(a).as("Результат соответствует ожиданию").isEqualTo(6);
    }

    @Test
    @DisplayName("Тест 2. Корректные данные сторон, но не результата")
    void incorrectResultData(){
        int a = triangleValues(3,4,5);
        assertThat(a).as("Результат не соответствует ожиданию").isNotEqualTo(1);
    }

    @Test
    @DisplayName("Тест 3. Длина значений не соответствует треугольнику")
    void incorrectData(){
        Exception exception = assertThrows(
                ArithmeticException.class,
                () -> triangleValues(-3,4,0));
        assertEquals("Стороны не могут быть иметь отрицательное значение и ровняться 0", exception.getMessage());
    }

    @Test
    @DisplayName("Тест 4. Значения не соответствует треугольнику")
    void NotTriangle(){
        Exception exception = assertThrows(
                ArithmeticException.class,
                () -> triangleValues(3,4,1000));
        assertEquals("Не корректное значения длины сторон треугольника", exception.getMessage());
    }
}