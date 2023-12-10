import "./App.css";
import { Provider } from "react-redux";
import store from "./redux/store";
import { Container } from "react-bootstrap";
import AddToDo from "./Components/AddToDo";
import DisplayTodos from "./Components/DisplayTodos";

function App() {
  return (
    <Provider store={store}>
      <Container className="py-3">
        <AddToDo />
        <DisplayTodos />
      </Container>
    </Provider>
  );
}

export default App;
