import logo from "./logo.svg";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./Pages/Home";
import About from "./Pages/About";
import Services from "./Pages/Services";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Login from "./Pages/Login";
import SignUp from "./Pages/SignUp";

function App() {
  return (
    <BrowserRouter>
      <ToastContainer position="bottom-center" />
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/Login/" element={<Login />}></Route>
        <Route path="/SignUp/" element={<SignUp />}></Route>
        <Route path="/About/" element={<About />}></Route>
        <Route path="/Services/" element={<Services />}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
