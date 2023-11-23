import React from "react";
import { UseStateArrayData, people } from "../UseStateArrayData";
import { useState } from "react";
import { useReducer } from "react";

const CLEAR_LIST = "CLEAR_LIST";
const RESET_LIST = "RESET_LIST";
const REMOVE_ITEM = "REMOVE_ITEM";

const defaultState = {
  people: UseStateArrayData,
};

const reducer = (state, action) => {
  if (action.type === CLEAR_LIST) {
    return { ...state, people: [] };
  } else if (action.type === RESET_LIST) {
    return { ...state, people: UseStateArrayData };
  } else if (action.type === REMOVE_ITEM) {
    let newPeople = state.people.filter(
      (person) => person.id !== action.payload.id
    );
    return {
      ...state,
      people: newPeople,
    };
  }
  return state;
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
