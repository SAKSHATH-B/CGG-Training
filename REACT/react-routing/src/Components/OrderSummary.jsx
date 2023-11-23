import React from "react";
import { useNavigate } from "react-router-dom";

export const OrderSummary = () => {
  const navigate = useNavigate();
  return (
    <>
      <h2>Order Confirmed</h2>
      <button onClick={() => navigate("/")}>Return to Home Page</button>
    </>
  );
};
