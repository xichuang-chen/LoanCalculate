
import React, {useEffect, useRef, useState} from 'react';
import {Button, Input, InputContainer, Lable, Wrapper} from "./style";
import {Select} from "antd";

import 'antd/dist/antd.css';
import {Answer} from "./Answer";

const {Option} = Select;

const response = {
  total: 2002
}


export const Calculator = () => {

  const totalRef = useRef(null);
  const rateRef = useRef(null);
  const periodRef = useRef(null);
  const paymentRef = useRef(null);
  const [type, setType] = useState("shorten_period");
  const [isDisplay, setIsDisplay] = useState(false);
  const [loanData, setLoanData] = useState(null);

  const handleChange = (value) => {
    console.log("select value: ", value);
    if (value == "time") {
      setType("shorten_period");
    } else {
      setType("reduce_average");
    }
  }

  const handleClick = () => {
    const otherPram = {
      method: 'POST',
      body: JSON.stringify({
        totalLoan: totalRef.current.value,
        rate: rateRef.current.value,
        period: periodRef.current.value,
        payment: paymentRef.current.value,
        type: type
      }),
      mode: 'cors',
      headers: {
        "Content-Type": "application/json"
      }
    };
    fetch('http://localhost:8080/calculate', otherPram)
      .then(data => {
        return data.body;
      })
      .then(res => console.log(res));

    setIsDisplay(true);
  }

  const data = {
    totalRepayment: 900000,
    remainRepayment: 900000,
    reduceTotal: 0,
    originalMonthly: [100, 200],
    afterMonthly: [100, 25],
  }

  return <Wrapper>
      <InputContainer>
        <Lable>总贷款数</Lable>
        <Input type="text" ref={totalRef}/>
        <Lable>利率</Lable>
        <Input type="text" ref={rateRef}/>
        <Lable>还款周期</Lable>
        <Input type="text" ref={periodRef}/>
        <Lable>还款金额</Lable>
        <Input type="text" ref={paymentRef}/>
        <Lable>还款类型</Lable>
        <Select defaultValue="average" onChange={handleChange}>
          <Option value="time">每月还款金额不变，还款年限缩短</Option>
          <Option value="average">还款年限不变，每月还款金额减少</Option>
        </Select>
        <Button onClick={handleClick}>查询</Button>
        {isDisplay && <Answer data={data}></Answer>}
      </InputContainer>

    </Wrapper>
}