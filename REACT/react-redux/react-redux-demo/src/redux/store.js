import { legacy_createStore, applyMiddleware } from "redux";
import logger from "redux-logger";
// import cakeReducer from "./Cake/cakeReducer";
import thunk from "redux-thunk";
import rootReducer from "./rootReducer";

const store = legacy_createStore(rootReducer, applyMiddleware(logger, thunk));

export default store;
