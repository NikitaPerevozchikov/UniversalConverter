package main.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ConvertService {
    private Conversion conversion;

    public ConvertService() {
        conversion = new Conversion();
    }

    public ResponseEntity<Double> parsingExpression(String from, String to) {
        if (!conversion.isCompletionFraction(from, to)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        if (!conversion.isParsingExpression()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        if (conversion.isConvert()) {
            return new ResponseEntity<>(conversion.getConvertIndex(), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
