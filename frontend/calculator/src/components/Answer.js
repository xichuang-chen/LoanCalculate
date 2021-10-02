import React, {useRef, useState} from 'react';
import {AnswerContainer, Text} from "./style";


export const Answer = (props) => {
  console.log("data: ", props.data.totalRepayment);
  return <AnswerContainer>
      <Text>原来要还本息: {props.data.totalRepayment}</Text>
      <Text>现在要还本息: {props.data.remainRepayment}</Text>
    </AnswerContainer>
};