package com.cxc.loan.service;

import com.cxc.loan.domain.CalculateInterface;
import com.cxc.loan.dto.CalculateInfo;
import com.cxc.loan.dto.LoanInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    CalculateInterface calculateInterface;

    public CalculateInfo loanCalculate(LoanInfo loanInfo) {
        if (loanInfo.getType().equals("shorten_period")) {
            return calculateInterface.shortenTime(loanInfo);
        }
        return calculateInterface.reduceMonthlyPayment(loanInfo);
    }
}
