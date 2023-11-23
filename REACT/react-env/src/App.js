import "./App.css";

function App() {
  return (
    <div className="App">
      <h2>Hello There I am Here</h2>
      <h3>{process.env.REACT_APP_NAME}</h3>
      <h3>ENV : {process.env.REACT_APP_ENV}</h3>
      <h4>{process.env.REACT_APP_API_URL}</h4>
    </div>
  );
}

export default App;
