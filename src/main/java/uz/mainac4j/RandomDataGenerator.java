package uz.mainac4j;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RandomDataGenerator {
    private final Random random;


    public RandomDataGenerator() {
        this.random = new SecureRandom();
    }

    public RandomDataGenerator(long seed) {
        this.random = new SecureRandom();
        this.random.setSeed(seed);
    }

    public int randomInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public double randomDouble(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    public boolean randomBoolean() {
        return random.nextBoolean();
    }

    public String randomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    public LocalDate randomDate(LocalDate start, LocalDate end) {
        long days = ChronoUnit.DAYS.between(start, end);
        return start.plusDays(random.nextInt((int) days + 1));
    }

    public UUID randomUUID() {
        return UUID.randomUUID();
    }
    public String randomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com"};
        return randomString(8) + "@" + domains[random.nextInt(domains.length)];
    }

    public String randomPhoneNumber() {
        return "+1-" + randomInt(100, 999) + "-" + randomInt(100, 999) + "-" + randomInt(1000, 9999);
    }

    public String randomName() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Edward", "Fiona");
        return names.get(random.nextInt(names.size()));
    }

    public <T> T randomElementFromList(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }
}
