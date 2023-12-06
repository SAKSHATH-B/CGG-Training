import "./App.css";
import { Provider } from "react-redux";
import store from "./redux/store";
import { Container } from "react-bootstrap";

function App() {
  return (
    <div className="App">
      <Provider store={store}>
        <Container className="py-3">hrllo</Container>
      </Provider>
    </div>
  );
}

export default App;
