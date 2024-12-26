package configs;

import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import lombok.NonNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LocalConfig implements Config {

    private static volatile LocalConfig INSTANCE;
    private final Properties properties = new Properties();

    private LocalConfig() {
        loadProperties("src/test/resources/config.properties");
    }

    public static LocalConfig getInstance() {
        if (INSTANCE == null) {
            synchronized (LocalConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocalConfig();
                }
            }
        }
        return INSTANCE;
    }

    private void loadProperties(@NonNull String filePath) {
        try (InputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось загрузить файл конфигурации: " + filePath, e);
        }
    }

    public @Nullable String getProperty(@NonNull String propertyName) {
        return properties.getProperty(propertyName);
    }
}
