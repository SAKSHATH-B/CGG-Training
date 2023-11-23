import React from "react";
import { useParams } from "react-router-dom";

export const UserDetails = () => {
  //   const params = useParams();
  //   const Id = params.Id;

  const { Id } = useParams();
  return <div>Details about User {Id}</div>;
};
