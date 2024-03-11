import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import Axiosss from "./components/Axiosss";
import ApiCall from "./components/ApiCall";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import TestForm from "./components/TestForm";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/dog" element={<Axiosss />} />
        <Route path="/red" element={<ApiCall />} />
        <Route path="/formtest" element={<TestForm />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
