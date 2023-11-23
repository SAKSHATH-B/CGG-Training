import "./App.css";
import { useState } from "react";
// import UseStateArray from "./Components/UseStateArray";
// import { UseStateObject } from "./Components/UseStateObject";
// import { UseStateCounter } from "./Components/UseStateCounter";
import { UseEffectCounter } from "./Components/UseEffectCounter";
import { MultipleEffects } from "./Components/multipleEffects";
import { FetchDatauseEffect } from "./Components/FetchDatauseEffect";
import { MultipleReturnsBasics } from "./Components/MultipleReturnsBasics";
import { MultipleReturnsFetchData } from "./Components/MultipleReturnsFetchData";
import { ShortCircuitEvaluation } from "./Components/shortCircuitEvaluation";
import { ToggleChallenge } from "./Components/ToggleChallenge";
import { UserChallenge } from "./Components/UserChallenge";
import { CleanupFunction } from "./Components/CleanupFunction";
import { LeverageJavascript } from "./Components/LeverageJavascript";
import { FormControlledInputs } from "./Components/FromControl/FormControlledInputs";
import { ControlledInputsChallenge } from "./Components/FromControl/ControlledInputsChallenge";
import { FormMultipleInputs } from "./Components/FromControl/FormMultipleInputs";
import { OtherInputs } from "./Components/FromControl/OtherInputs";

function App() {
  // const [count, setCount] = useState(0);
  // const btnHandler = () => {
  //   setCount(count + 1);
  //   console.log(count);
  // };
  return (
    <>
      {/* <h1>{count}</h1>
      <button onClick={btnHandler}>+</button> */}
      {/* <UseStateArray /> */}
      {/* <UseStateObject /> */}
      {/* <UseStateCounter /> */}
      {/* <UseEffectCounter /> */}
      {/* <MultipleEffects /> */}
      {/* <FetchDatauseEffect /> */}
      {/* <MultipleReturnsBasics /> */}
      {/* <MultipleReturnsFetchData /> */}
      {/* <ShortCircuitEvaluation /> */}
      {/* <ToggleChallenge /> */}
      {/* <UserChallenge /> */}
      {/* <CleanupFunction /> */}
      {/* <LeverageJavascript /> */}
      {/* <FormControlledInputs /> */}
      {/* <ControlledInputsChallenge /> */}
      {/* <FormMultipleInputs /> */}
      <OtherInputs />
    </>
  );
}

export default App;
