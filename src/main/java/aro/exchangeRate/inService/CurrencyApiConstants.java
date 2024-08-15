package aro.exchangeRate.inService;

/**
 * Заметка на будущее:
 * <p>
 * параметры useFake, BASE_API_URL, HISTORICAL_PATH, LATEST_PATH, API_KEY_VALUE должны быть
 * выведены в конфигурационный файл {@link new interface CurrencyApiConfig},
 * где будет собственная реализация для прода {@link new class CurrencyApiConfigReal},
 * а также для тестового режима - фейковая реализация {@link new class CurrencyApiConfigForTests}
 * <p>
 * остальные параметры оставить внутри данного класса как константы
 */
public class CurrencyApiConstants {

    public final static boolean useFake = false;

    public final static String BASE_API_URL = "https://api.currencyapi.com/v3";
    public final static String HISTORICAL_PATH = "historical";
    public final static String LATEST_PATH = "latest";
    public final static String API_KEY_VALUE = "cur_live_IHhLhIVwNKDGirLYFH8ksqx7w7TcvbGHM3mAzPVb";

    public final static String DATE = "date";
    public final static String BASE_CURRENCY = "base_currency";
    public final static String CURRENCIES = "currencies";
    public final static String API_KEY = "apikey";

}
