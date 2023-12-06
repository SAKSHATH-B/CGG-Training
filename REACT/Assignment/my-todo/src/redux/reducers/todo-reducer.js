import {
  ADD_TODO,
  CLEAR_TODO,
  DELETE_TODO,
  UPDATE_TODO,
} from "../action/action-types";

const initialState = [];

export default (state = initialState, action) => {
  switch (action.type) {
    case ADD_TODO:
      console.log("Adding todo");
      console.log(action.payload);
      return [...state, action.payload];

    case DELETE_TODO:
      const newState = state.filter((todo) => todo.id !== action.payload);
      return newState;

    case CLEAR_TODO:
      return [];

    default:
      return state;
  }
};
