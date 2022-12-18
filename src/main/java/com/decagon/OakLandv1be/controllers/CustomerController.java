package com.decagon.OakLandv1be.controllers;

import com.decagon.OakLandv1be.dto.SignupRequestDto;
import com.decagon.OakLandv1be.dto.SignupResponseDto;
import com.decagon.OakLandv1be.exceptions.AlreadyExistsException;
import com.decagon.OakLandv1be.services.CustomerService;
import com.decagon.OakLandv1be.utils.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignupResponseDto>> signup(@Valid @RequestBody SignupRequestDto signupRequestDto) throws AlreadyExistsException {
        ApiResponse<SignupResponseDto> customer = customerService.saveCustomer(signupRequestDto);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping("/cart/item/delete/{itemId}")

    public ResponseEntity<String> deleteItem(@PathVariable Long itemId){
        customerService.removeItemInCart();
        return new ResponseEntity<>("Item removed", HttpStatus.NO_CONTENT);
    }
}
