package com.cxc.loan.domain;

import com.cxc.loan.dto.CalculateInfo;
import com.cxc.loan.dto.LoanInfo;

public interface CalculateInterface {
    CalculateInfo shortenTime(LoanInfo loanInfo);
    CalculateInfo reduceMonthlyPayment(LoanInfo loanInfo);
}
