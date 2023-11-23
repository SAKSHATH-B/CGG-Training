import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import { ParentComponent } from "./Components/ParentComponent";
import Counter from "./Components/Counter";
import { FocusInput } from "./Components/FocusInput";
import ClassTimer from "./Components/ClassTimer";
import HookTimer from "./Components/HookTimer";
import { DocTitleOne } from "./Components/Custom Hooks/DocTitleOne";
import { DocTitleTwo } from "./Components/Custom Hooks/DocTitleTwo";
import { CounterOne } from "./Components/Custom Hooks/CounterOne";
import { CounterTwo } from "./Components/Custom Hooks/CounterTwo";
import { UserForm } from "./Components/Custom Hooks/UserForm";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      {/* <ParentComponent /> */}
      {/* <Counter /> */}
      {/* <FocusInput /> */}
      {/* <ClassTimer /> */}
      {/* <HookTimer /> */}
      {/* <DocTitleOne /> */}
      {/* <DocTitleTwo /> */}
      {/* <CounterOne /> */}
      {/* <CounterTwo /> */}
      <UserForm />
    </>
  );
}

export default App;
