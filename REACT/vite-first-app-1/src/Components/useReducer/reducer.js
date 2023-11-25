import { CLEAR_LIST, RESET_LIST, REMOVE_ITEM } from "./actions";
import { UseStateArrayData } from "../UseStateArrayData";

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

export default reducer;
