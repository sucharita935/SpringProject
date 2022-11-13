package com.eazyBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

	@GetMapping("/contact")
    public String getCardDetails() {
        return "Here are the card details from the DB";
    }
}
