import React, { useReducer } from "react";
//By using action as an object
//By using state as an object
export const CounterTwo = () => {
  //   const initialState = 0;
  const initialState = {
    firstCounter: 0,
    secondCounter: 10,
  };
  const reducer = (state, action) => {
    switch (action.type) {
      case "increment":
        // return state + action.value;
        return { ...state, firstCounter: state.firstCounter + action.value };
      case "decrement":
        return { ...state, firstCounter: state.firstCounter - action.value };
      case "increment2":
        // return state + action.value;
        return { ...state, secondCounter: state.secondCounter + action.value };
      case "decrement2":
        return { ...state, secondCounter: state.secondCounter - action.value };
      case "reset":
        return initialState;
      default:
        return state;
    }
  };
  const [count, dispatch] = useReducer(reducer, initialState);
  return (
    <div>
      --------------------------------------------------------------------------------------
      <div>Count -- {count.firstCounter}</div>
      <button onClick={() => dispatch({ type: "increment", value: 1 })}>
        Increment
      </button>
      <button onClick={() => dispatch({ type: "decrement", value: 1 })}>
        Decrement
      </button>
      <button onClick={() => dispatch({ type: "increment", value: 5 })}>
        Increment Five
      </button>
      <button onClick={() => dispatch({ type: "decrement", value: 5 })}>
        Decrement Five
      </button>
      <button onClick={() => dispatch({ type: "reset" })}>Reset</button>
      <div>
        <div>Count -- {count.secondCounter}</div>
        <button onClick={() => dispatch({ type: "increment2", value: 1 })}>
          Increment2
        </button>
        <button onClick={() => dispatch({ type: "decrement2", value: 1 })}>
          Decrement2
        </button>
        <button onClick={() => dispatch({ type: "increment2", value: 5 })}>
          Increment2 Five
        </button>
        <button onClick={() => dispatch({ type: "decrement2", value: 5 })}>
          Decrement2 Five
        </button>
      </div>
    </div>
  );
};
