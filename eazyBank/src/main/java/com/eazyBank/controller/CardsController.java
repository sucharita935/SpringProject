package com.eazyBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

	@GetMapping("/myCards")
	public String saveContactInquiryDetails() {
        return "Inquiry details are saved to the DB";
    }
}
