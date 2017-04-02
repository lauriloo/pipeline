package ee.meriloo.toru.service.input;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InputParsingService {

    public List<BigDecimal> getRectangleDimension(String input) throws Exception {
        try {
            return convertToList(input).subList(0, 2);
        } catch (Exception e) {
            throw new Exception("Not valid input: " + input);
        }
    }

    public List<BigDecimal> getPipesDiameters(String input) throws Exception {
        try {
            List<BigDecimal> inputNumbers = convertToList(input);
            return inputNumbers.subList(2, inputNumbers.size());
        } catch (Exception e) {
            throw new Exception("Not valid input");
        }
    }

    private List<BigDecimal> convertToList(String input) throws Exception{
        List<String> inputAsList = Arrays.asList(input.split(","));
        List<BigDecimal> inputAsNumbers = inputAsList.stream()
                .map(String::trim)
                .map(e -> BigDecimal.valueOf(Double.valueOf(e)))
                .collect(Collectors.toList());
        if (inputAsNumbers.size() < 4 ) throw new Exception();
        return inputAsNumbers;
    }
}
