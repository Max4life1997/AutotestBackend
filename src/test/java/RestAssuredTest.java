import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.UserSteps;


public class RestAssuredTest extends BaseTest {
    @Test
    @DisplayName("Example test")
    @Description("This is an example test for Allure")
    void checkUsers() {
        new UserSteps().getUserById(1);
    }
}
