import React from "react";
import { UseStateArrayData } from "../UseStateArrayData";
import { useReducer } from "react";
import { CLEAR_LIST, RESET_LIST, REMOVE_ITEM } from "./actions";
import reducer from "./reducer";

const defaultState = {
  people: UseStateArrayData,
};

export const ReducerBasics = () => {
  const [state, dispatch] = useReducer(reducer, defaultState);

  const removeItem = (id) => {
    dispatch({ type: REMOVE_ITEM, payload: { id } });
    // const newPeople = people.filter((person) => person.id !== id);
    // setPeople(newPeople);
  };

  const clearList = () => {
    // setPeople([]);
    dispatch({ type: CLEAR_LIST });
  };

  const resetList = () => {
    // setPeople(UseStateArrayData);
    dispatch({ type: RESET_LIST });
  };

  console.log(state);

  return (
    <div>
      {state.people.map((person) => {
        // console.log(person);
        const { id, name } = person;
        return (
          <div key={id}>
            <h4>{name}</h4>
            <button onClick={() => removeItem(id)}>Remove</button>
          </div>
        );
      })}
      {state.people.length < 1 ? (
        <button onClick={resetList}>Reset</button>
      ) : (
        <button onClick={clearList}>Clear</button>
      )}
    </div>
  );
};
