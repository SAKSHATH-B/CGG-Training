import logo from "./logo.svg";
import { ThemeProvider, createGlobalStyle } from "styled-components";
import "./App.css";
import "./styles.css";
import StyledButton, {
  FancyButton,
  SubmitButton,
} from "./components/Button/Button";
import { AnimatedLogo, DarkButton } from "./components/Button/Button.styles";

const theme = {
  dark: {
    primary: "#000",
    text: "#fff",
  },
  light: {
    primary: "#fff",
    text: "#000",
  },
};

const GlobalStyle = createGlobalStyle`
  button{
    font-family: 'Roboto';
  }
`;

function App() {
  return (
    <div className="App">
      <ThemeProvider theme={theme}>
        <GlobalStyle />
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
        <AnimatedLogo src={logo} />
        <button>Button</button>
        <br />
        <br />
        <StyledButton>Styled Button</StyledButton>
        <br />
        <br />
        <StyledButton variant="outline">Styled Button</StyledButton>
        <br />
        <br />
        <FancyButton>Fancy Button</FancyButton>
        <br />
        <br />
        <SubmitButton>Submit Button</SubmitButton>
        <br />
        <br />
        <DarkButton>Dark Button</DarkButton>
      </ThemeProvider>
    </div>
  );
}

export default App;
