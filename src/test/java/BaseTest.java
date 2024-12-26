import io.qameta.allure.Epic;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.AllureTestListener;

@Epic("Тестирование бека")
@ExtendWith(AllureTestListener.class)
public class BaseTest {

    @BeforeAll
    static void setup() {

    }

    @AfterAll
    static void cleanup() {

    }
}
