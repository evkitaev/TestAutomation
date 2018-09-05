package FirstPackage;
import methods.first.Print;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrintTest {
    @Test
    @DisplayName("Проверка вывода")
    public void printTest() {
        String result = Print.print("Дальше действовать будем мы");
        Assertions.assertEquals("Слоган: Дальше действовать будем вы", result, "Вывод некорректен!");
    }
}
