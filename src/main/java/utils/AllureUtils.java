package utils;

import io.qameta.allure.Attachment;

public class AllureUtils {

    @Attachment(value = "Тестовые логи", type = "text/plain")
    public static byte[] attachLogs(String message) {
        return message.getBytes();
    }
}