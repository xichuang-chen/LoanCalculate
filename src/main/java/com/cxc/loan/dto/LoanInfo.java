package com.cxc.loan.dto;

import lombok.Data;

@Data
public class LoanInfo {
    private double totalLoan;
    private double rate;
    private double period;
    private double payment;
    private String type;
}
