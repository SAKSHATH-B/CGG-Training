import React, { useState } from "react";
import CustomNavbar from "./CustomNavbar";
import { useAuth0 } from "@auth0/auth0-react";

const SupportPage = () => {
  const { loginWithRedirect } = useAuth0();

  return (
    <div>
      <CustomNavbar />
      support page
      <button
        onClick={() => {
          loginWithRedirect();
        }}
      >
        LogIn
      </button>
    </div>
  );
};

export default SupportPage;
