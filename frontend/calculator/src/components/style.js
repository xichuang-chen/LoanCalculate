import styled from 'styled-components'

export const Wrapper = styled.div`
  position: absolute;
  background-color: white;
  border-radius: 5px;
  width: 400px;
  height: 180px;
`;


export const InputContainer = styled.div`
    padding: 5px 10px;
`;


export const Lable = styled.label`
  font-size: 10px;
`;

export const Input = styled.input`
  height: 10px;
  width: 80%;
  overflow: auto;
  display: flex;
  align-items: flex-start;
  padding: 0.5rem;
`;

export const Button = styled.button`
  padding: 2px;
  border-radius: 2px;
  border: 1px solid black;
  display: flex;
  justify-content: center;
  background-color: transparent;
  :hover{
    cursor: pointer;
    box-shadow: 0 2px 6px 0 rgba(0,0,0,0.05),0 17px 50px 0 rgba(0,0,0,0.15);
    background-color: rgb(242, 242, 242);
  }
`;

export const AnswerContainer = styled.div`
`;

export const Text = styled.span`
  display: block;
  position: relative;
  overflow: hidden;
  text-overflow: ellipsis;
  background-color: rgb(242, 242, 242);
`;

