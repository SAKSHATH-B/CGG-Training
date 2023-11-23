import styled, { keyframes } from "styled-components";

export const StyledButton = styled.button`
  border: 2px solid orange;
  background-color: ${(props) =>
    props.variant === "outline" ? "white" : "orange"};
  color: ${(props) => (props.variant === "outline" ? "orange" : "white")};
  padding: 15px 32px;
  font-size: 16px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  transition: 0.5s all ease-out;
  &:hover {
    background-color: ${(props) =>
      props.variant !== "outline" ? "white" : "orange"};
    color: ${(props) => (props.variant !== "outline" ? "orange" : "white")};
  }
`;

export const FancyButton = styled(StyledButton)`
  background-image: linear-gradient(to right, orange 0%, red 100%);
  border: none;
`;

export const SubmitButton = styled(StyledButton).attrs({ type: "submit" })`
  background-color: green;
  color: white;
  border: 2px green;
  &:hover {
    background-color: green;
    color: white;
    border: 2px green;
  }
`;

const rotate = keyframes`
from{
  transform: rotate(0deg);
}
to{
  transform: rotate(360deg);
}
`;

export const AnimatedLogo = styled.img`
  height: 40vmin;
  pointer-events: none;
  animation: ${rotate} infinite 20s linear;
`;

export const DarkButton = styled(StyledButton)`
  border: 2px solid ${(props) => props.theme.dark.primary};
  background-color: ${(props) => props.theme.dark.primary};
  color: ${(props) => props.theme.dark.text};
`;
