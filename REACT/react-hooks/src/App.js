import "./App.css";
// import { ComponentC } from "./Components/ComponentC";
import React, { useReducer } from "react";
// import { ComponentA } from "./Components/ComponentA";
// import { ComponentB } from "./Components/ComponentB";
// import { ComponentC } from "./Components/ComponentC";
import { DataFetchingTwo } from "./Components/DataFetchingTwo";
// import { CounterOne } from "./Components/CounterOne";
// import { CounterTwo } from "./Components/CounterTwo";
// import { CounterThree } from "./Components/CounterThree";
// import { DataFetching } from "./Components/DataFetching";
// import { DataFetchingOne } from "./Components/DataFetchingOne";
// import { MouseContainer } from "./Components/MouseContainer";
// import ClassMouse from "./Components/ClassMouse";
// import { HookMouse } from "./Components/HookMouse";
// import { ClassCounterOne } from "./Components/ClassCounterOne";
// import { HookCounterOne } from "./Components/HookCounterOne";
// import IntervalClassCounter from "./Components/IntervalClassCounter";
// import { IntervalHookCounter } from "./Components/IntervalHookCounter";
// import { HookCounterFour } from "./Components/HookCounterFour";
// import { HookCounterThree } from "./Components/HookCounterThree";
// import ClassCounter from "./Components/ClassCounter";
// import ClassCounterTwo from "./Components/ClassCounterTwo";
// import { HookCounter } from "./Components/HookCounter";
// import { HookCounterTwo } from "./Components/HookCounterTwo";

// export const userContext = React.createContext();
// export const companyContext = React.createContext();

// const initialState = 0;
// const reducer = (state, action) => {
//   switch (action) {
//     case "increment":
//       return state + 1;
//     case "decrement":
//       return state - 1;
//     case "reset":
//       return initialState;
//     default:
//       return state;
//   }
// };

// export const counterContext = React.createContext();

function App() {
  // const [count, dispatch] = useReducer(reducer, initialState);
  return (
    <div className="App">
      {/* <ClassCounter /> */}
      {/* <HookCounter /> */}
      {/* <ClassCounterTwo /> */}
      {/* <HookCounterTwo /> */}
      {/* <HookCounterThree /> */}
      {/* <HookCounterFour /> */}
      {/* <ClassCounterOne /> */}
      {/* <HookCounterOne /> */}
      {/* <IntervalClassCounter /> */}
      {/* <IntervalHookCounter /> */}
      {/* <ClassMouse /> */}
      {/* <HookMouse /> */}
      {/* <MouseContainer /> */}
      {/* <DataFetching /> */}
      {/* <DataFetchingOne /> */}
      {/* <userContext.Provider value={"Sakshath"}>
        <companyContext.Provider value={"CGG"}>
          <ComponentC />
        </companyContext.Provider>
      </userContext.Provider> */}
      {/* <CounterOne /> */}
      {/* <CounterTwo /> */}
      {/* <CounterThree /> */}
      {/* <div>Count -- {count}</div>
      <counterContext.Provider
        value={{ counter: count, dispatchCount: dispatch }}
      >
        <ComponentA />
        <ComponentB />
        <ComponentC />
      </counterContext.Provider> */}

      <DataFetchingTwo />
    </div>
  );
}

export default App;
