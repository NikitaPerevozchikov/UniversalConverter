package main.controllers;

import main.model.ConvertService;
import main.model.ConvertUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ConvertController {

    ConvertService convertService = new ConvertService();

    @PostMapping("/")
    public ResponseEntity<?> convert(@RequestBody ConvertUpdateRequest convertUpdateRequest) {
        return convertService.parsingExpression(convertUpdateRequest.getFrom(), convertUpdateRequest.getTo());
    }



}
