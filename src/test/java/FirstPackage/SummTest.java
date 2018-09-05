package FirstPackage;
import methods.first.Summ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SummTest {
    @Test
    @DisplayName("Проверка суммы")
    public void firstTest(){
        double result = Summ.summ(2,2);
        Assertions.assertEquals(6.0,result,"Результат отличен от ожидаемого");
    }

}
