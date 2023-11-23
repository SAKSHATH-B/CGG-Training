import React from "react";
import { useState } from "react";

export const ToggleChallenge = () => {
  const [showAlert, setShowAlert] = useState(false);
  //   const toggle = () => {
  //     if (showAlert) {
  //       setShowAlert(false);
  //       return;
  //     }
  //     setShowAlert(true);
  //   };

  return (
    <div>
      <button className="btn" onClick={() => setShowAlert(!showAlert)}>
        Toggle
      </button>
      {showAlert && <Alert />}
    </div>
  );
};

const Alert = () => {
  return <div className="alert">Hello Anonymous</div>;
};
