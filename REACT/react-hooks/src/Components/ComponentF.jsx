import React, { useContext } from "react";
import { counterContext } from "../App";
// import { userContext, companyContext } from "../App";

export const ComponentF = () => {
  const count = useContext(counterContext);
  return (
    <div>
      {/* <userContext.Consumer>
        {(user) => {
          return (
            <companyContext.Consumer>
              {(company) => {
                return (
                  <div>
                    User Context Value is {user} and Company Context Value is{" "}
                    {company}
                  </div>
                );
              }}
            </companyContext.Consumer>
          );
        }}
      </userContext.Consumer> */}
      Component F<div>count -- {count.counter}</div>
      <button onClick={() => count.dispatchCount("increment")}>
        Increment
      </button>
      <button onClick={() => count.dispatchCount("decrement")}>
        Decrement
      </button>
      <button onClick={() => count.dispatchCount("reset")}>Reset</button>
    </div>
  );
};
