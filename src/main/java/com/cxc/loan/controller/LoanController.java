package com.cxc.loan.controller;

import com.cxc.loan.dto.CalculateInfo;
import com.cxc.loan.dto.LoanInfo;
import com.cxc.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/test")
    public String test() {
        String msg = "server is start!";
        return msg;
    }

    @PostMapping("/calculate")
    public CalculateInfo calculate(LoanInfo loanInfo) {
        return loanService.loanCalculate(loanInfo);
    }
}
