package com.cxc.loan.domain;

import com.cxc.loan.dto.CalculateInfo;
import com.cxc.loan.dto.LoanInfo;
import org.springframework.stereotype.Component;

@Component
public class Calculate implements CalculateInterface {
    private static double total = 572360.92 - 650000/360 * 12;
    private static double rate = 0.05145;

    public static double calculate(int repayment) {
        double totalRemain = total - repayment * 10000;
        double average = totalRemain / 305;
        double totalRepayment = 0;

        for(int i = 0; i < 305; i++) {
            double interest = (totalRemain - average * i) * rate / 12;
            double monthRepayment = interest + average;
            if (repayment != 0) {
                System.out.println(monthRepayment);
            }
            totalRepayment += monthRepayment;
        }
        System.out.println("repay " + repayment + "wan total repayment is: " + totalRepayment);
        return totalRepayment;
    }

    @Override
    public CalculateInfo shortenTime(LoanInfo loanInfo) {
        return null;
    }

    @Override
    public CalculateInfo reduceMonthlyPayment(LoanInfo loanInfo) {
        CalculateInfo after = reduceMonthlyCalculate(loanInfo);
        loanInfo.setPayment(0);
        CalculateInfo origin = reduceMonthlyCalculate(loanInfo);
        CalculateInfo response = new CalculateInfo();
        response.setReduceTotal(origin.getTotalRepayment() - after.getTotalRepayment());
        response.setTotalRepayment(origin.getTotalRepayment());
        response.setRemainRepayment(after.getTotalRepayment());
        response.setAfterMonthly(after.getOriginalMonthly());
        response.setOriginalMonthly(origin.getOriginalMonthly());
        return response;
    }

    public CalculateInfo reduceMonthlyCalculate(LoanInfo loanInfo) {
        double totalRemain = loanInfo.getTotalLoan() - loanInfo.getPayment();
        double average = totalRemain / loanInfo.getPeriod();
        double totalRepayment = 0;

        CalculateInfo calculateInfo = new CalculateInfo();
        for(int i = 0; i < loanInfo.getPeriod(); i++) {
            double interest = (totalRemain - average * i) * loanInfo.getRate() / 12;
            double monthRepayment = interest + average;
            calculateInfo.getOriginalMonthly().add(monthRepayment);
            totalRepayment += monthRepayment;
            calculateInfo.setTotalRepayment(totalRepayment);
        }
        return calculateInfo;
    }

    public static void main(String[] args) {
        calculate(0);
    }
}
