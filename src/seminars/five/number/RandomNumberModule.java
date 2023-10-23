package seminars.five.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberModule {
    public static List<Integer> generateRandomNumbers(int count) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        if (count < 0){
            throw new IllegalArgumentException("Ошибка");
        }
        for (int i = 0; i < count; i++) {
            randomNumbers.add(random.nextInt(1,101));
        }
        return randomNumbers;
    }
}