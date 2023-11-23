import React from "react";
import { UserConsumer } from "./userContext";

export const CompF = () => {
  return (
    <UserConsumer>
      {(username) => {
        return <div>Hello {username}</div>;
      }}
    </UserConsumer>
  );
};
