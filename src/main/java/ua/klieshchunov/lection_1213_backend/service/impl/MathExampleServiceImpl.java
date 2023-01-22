package ua.klieshchunov.lection_1213_backend.service.impl;

import org.springframework.stereotype.Service;
import ua.klieshchunov.lection_1213_backend.service.MathExampleService;

import java.util.Random;

@Service
public class MathExampleServiceImpl implements MathExampleService {
    @Override
    public String generateSingleExample() {
        String[] operators = new String[]{"+", "-", "*", "/"};
        Random random = new Random();
        int firstPart = random.nextInt(100);

        int operatorIndex = random.nextInt(operators.length);
        String operator = operators[operatorIndex];

        int secondPart = random.nextInt(operators.length);
        return firstPart+operator+secondPart;
    }

    @Override
    public String[] generateExamplesArray(int quantity) {
        String[] examples = new String[quantity];

        for (int i = 0; i < quantity; i++) {
            examples[i] = generateSingleExample();
        }
        return examples;
    }
}
