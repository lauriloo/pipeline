package ee.meriloo.toru.service.input;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InputParsingService {

    public List<Double> getRectangleDimension(String input) throws Exception {
        try {
            return convertToList(input).subList(0, 2);
        } catch (Exception e) {
            throw new Exception("Not valid input: " + input);
        }
    }

    public List<Double> getPipesDiameters(String input) throws Exception {
        try {
            List<Double> inputNumbers = convertToList(input);
            return inputNumbers.subList(2, inputNumbers.size());
        } catch (Exception e) {
            throw new Exception("Not valid input");
        }
    }

    private List<Double> convertToList(String input) throws Exception{
        List<String> inputAsList = Arrays.asList(input.split(","));
        List<Double> inputAsNumbers = inputAsList.stream()
                .map(String::trim)
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        if (inputAsNumbers.size() < 4 ) throw new Exception();
        return inputAsNumbers;
    }
}
