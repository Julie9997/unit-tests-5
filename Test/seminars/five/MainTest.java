package seminars.five;

import org.junit.jupiter.api.Test;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.order.OrderService;
import seminars.five.order.PaymentService;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

class MainTest {
    //5.1.
    @Test
    public void testGenerateRandomNumbers() {
// Проверяем, что список чисел генерируется корректно
        List<Integer> numbers = RandomNumberModule.generateRandomNumbers(10);
        assertEquals(10, numbers.size());
    }

    @Test
    public void testGenerateRandomNumbersNegativeCount() {
// Проверяем, что при передаче отрицательного значения возвращается пустой список
        assertThatThrownBy(() -> RandomNumberModule.generateRandomNumbers(-5)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testModulesIntegration() {
// Генерируем список случайных чисел
        List<Integer> numbers = RandomNumberModule.generateRandomNumbers(10);
// Ищем максимальное число в списке
        int maxNumber = MaxNumberModule.findMaxNumber(numbers);
// Проверяем, что максимальное число найдено корректно
        assertEquals(Collections.max(numbers), maxNumber);
    }

    //5.2.
    @Test
    void testGetUserName() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String result = userService.getUserName(123);
        assertEquals("User 123", result);
    }

    //5.3.
    @Test
    void testTrueOrderService() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean res = orderService.placeOrder("1", 2.0);

        assertTrue(res);
    }
}