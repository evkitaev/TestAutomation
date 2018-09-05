package FirstPackage;
import methods.first.Factorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class FactorialTest {
    @Test
    @DisplayName("Тест факториала")
    public void factorialTest() {
        int result = Factorial.factorial(6);
        Assertions.assertEquals(720, result, "Ошибка расчета");
    }
}
