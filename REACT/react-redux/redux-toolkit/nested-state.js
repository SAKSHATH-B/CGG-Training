const redux = require("redux");
const createStore = redux.legacy_createStore;
const reduxLogger = require("redux-logger");
const produce = require("immer").produce;

const logger = reduxLogger.createLogger();
const applyMiddleware = redux.applyMiddleware;

const initialState = {
  name: "MarkAntony",
  address: {
    street: "Gachibowli",
    city: "Hyderabad",
    state: "TS",
  },
};

const STREET_UPDATED = "STREET_UPDATED";
const updateStreet = (street) => {
  return {
    type: STREET_UPDATED,
    payload: street,
  };
};

const streetReducer = (state = initialState, action) => {
  switch (action.type) {
    case STREET_UPDATED:
      //   return {
      //     ...state,
      //     address: {
      //       ...state.address,
      //       street: action.payload,
      //     },
      //   };
      return produce(state, (draft) => {
        draft.address.street = action.payload;
      });
    default:
      return state;
  }
};

const store = createStore(streetReducer, applyMiddleware(logger));
console.log("Initial State", store.getState());
const unsubscribe = store.subscribe(() => {});

store.dispatch(updateStreet("BioDiversity"));
unsubscribe();
