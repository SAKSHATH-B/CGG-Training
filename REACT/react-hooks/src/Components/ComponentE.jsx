import React, { useContext } from "react";
import { ComponentF } from "./ComponentF";
// import { companyContext, userContext } from "../App";

export const ComponentE = () => {
  // const user = useContext(userContext);
  // const company = useContext(companyContext);
  return (
    <div>
      <ComponentF />
      {/* {user} -- {company} */}
    </div>
  );
};
