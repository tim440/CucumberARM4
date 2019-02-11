/*
 * Copyright (c) 2018, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.rgs.WebTests;

/**
 * Значения - константы. В процессе работы тестов они не меняются.
 */
public class Constants {

    /**
     * Пользователь под которым запускаются тесты.
     */
    public static final String LOGIN = "Autotest";
    /**
     * Пароль пользователя под которым запускаются тесты.
     */
    static final String PASSWORD = "2wsx2WSX";
    /**
     * Запрос полученный из хрома, F12 -> Вкладка Network -> Выбрать нужный запрос -> Вкладка Headers, секция FormData
     * -> нажать на view source.
     */
    //protected static final String agent = "page=1&start=0&limit=100&filter=%5B%7B%22property%22%3A%22personTypeCode%22%2C%22value%22%3A%221%22%7D%2C%7B%22property%22%3A%22id%22%2C%22value%22%3A%22720183fb442407b3511e69c2c%22%7D%5D";
    public static final String agent =
            "page=1&start=0&limit=100&filter=[" +
                    "{\"property\":\"agentCode\",\"value\":\"72850010\"}," +
                    "{\"property\":\"branchCode\",\"value\":\"72850010\"}," +
                    "{\"property\":\"displayName\",\"value\":\"\\u0410\\u0432\\u0442\\u043e\\u0442\\u0435\\u0441\\u0442 \\u0424\\u0438\\u0437 \\u041b\\u0438\\u0446\\u043e\"}]";
    /**
     * Ключ для мапы Staroge при работе с одной сессией.
     */
    public static final String ONE_SESSION_KEY = "0";
    /**
     * Порт подключения к БД по умолчанию.
     */
    final static int PORT = 1521;
}
