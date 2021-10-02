package com.cxc.loan.dto;

import lombok.Data;

import java.util.List;

@Data
public class CalculateInfo {
    private double totalRepayment;
    private double remainRepayment;
    private double reduceTotal;
    private List<Double> originalMonthly;
    private List<Double> afterMonthly;
}
