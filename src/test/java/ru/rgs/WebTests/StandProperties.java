/*
 * Copyright (c) 2018, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.rgs.WebTests;

/**
 * Настройки площадок АРМ4.
 */
public enum StandProperties {

  //TEST1("arm4-test-odb3.tengry.com", "arm4-dev.tengry.com", "arm4tst", "KAIS_WEB_TEST1", "KAIS_WEB_TEST1"),//TODO
  LOCALHOST("arm4-dev-odb.tengry.com", "localhost:7002", "arm4dev", "KAIS_WEB_JDEV", "KAIS_WEB_JDEV", true, 10),
  TEST2("arm4-test-odb3.tengry.com", "arm4-test2-web.tengry.com", "arm4tst", "KAIS_WEB_TEST2", "kais_web_test2", 10),
  TEST3("arm4-test-odb3.tengry.com", "arm4-test3-web.tengry.com", "arm4tst", "KAIS_WEB_TEST3", "kais_web_test3", 10),
  DEV("arm4-dev-odb.tengry.com", "arm4-dev.tengry.com", "arm4dev", "KAIS_WEB_JDEV", "KAIS_WEB_JDEV", 10);

  //Количество потоков запуска
  private int threadCount;
  /**
   * Хост для подключения к БД.
   */
  private String host;
  /**
   * URL где крутиться WEB часть.
   */
  private String url;
  /**
   * sid поключения к БД.
   */
  private String sid;
  /**
   * Пользователь поключения к БД.
   */
  private String user;
  /**
   * Пароль поключения к БД.
   */
  private String password;
  /**
   * Поддерка нескольких сессий одного и того же пользователя.
   * false - по умолчанию.
   * нужно выставить false если площадка выбивает одного и того же пользователя.
   */
  private boolean multisession = false;

  StandProperties(String host, String url, String sid, String user, String password, int threadCount) {
    this.host = host;
    this.url = url;
    this.sid = sid;
    this.user = user;
    this.password = password;
    this.threadCount = threadCount;
  }

  StandProperties(String host, String url, String sid, String user, String password, boolean multisession, int threadCount) {
    this.host = host;
    this.url = url;
    this.sid = sid;
    this.user = user;
    this.password = password;
    this.multisession = multisession;
    this.threadCount = threadCount;
  }

  /**
   * Ищу в урле для подключения названия текущих ENUM без учёта регистра
   */
  public static StandProperties findByString(String baseUrl) {
    String urlInUpper = baseUrl.toUpperCase();
    for (StandProperties value : values()) {
      if (urlInUpper.contains(value.name())) {
        return value;
      }
    }
    System.out.println("ERROR!! CAN'T FOUND STAND");
    return null;

  }

  public String getDbConnetionString() {
    return String.format("jdbc:oracle:thin:@%s:%d/%s", host, Constants.PORT, sid);
  }

  public String getUrl() {
    return "http://" + url + "/armweb/";
  }

  public String getHost() {
    return host;
  }

  public String getSid() {
    return sid;
  }

  public String getUser() {
    return user;
  }

  public String getPassword() {
    return password;
  }

  public boolean isMultisession() {
    return multisession;
  }

  public int getThreadCount() {
    return threadCount;
  }
}
