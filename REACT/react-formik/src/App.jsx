import "./App.css";
import EnrollmentForm from "./Components/EnrollmentForm";
import FormikContainer from "./Components/FormikContainer";
import LoginForm from "./Components/LoginForm";
import OldYoutubeForm from "./Components/OldYoutubeForm";
import Registration from "./Components/Registration";
import YoutubeForm from "./Components/YoutubeForm";
import { ThemeProvider, theme } from "@chakra-ui/react";

function App() {
  return (
    <ThemeProvider theme={theme}>
      <div className="App">
        {/* <OldYoutubeForm /> */}
        {/* <YoutubeForm /> */}
        {/* <FormikContainer /> */}
        <LoginForm />
        {/* <Registration /> */}
        {/* <EnrollmentForm /> */}
      </div>
    </ThemeProvider>
  );
}

export default App;
