package configs;


import lombok.NonNull;

public interface Config {

    static Config getInstance(@NonNull String env) {
        switch (env) {
            case "local":
                return LocalConfig.getInstance();
            default:
                throw new RuntimeException(String.format("Среда выполнениния %s не найдена", env));
        }
    }

    String getProperty(@NonNull String propertyName);
}
