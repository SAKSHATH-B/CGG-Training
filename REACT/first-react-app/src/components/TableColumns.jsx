import React, { Fragment } from "react";

export default function TableColumns() {
  const items = ["abc", "xyz", "pqr", "uvw"];
  return (
    <>
      <td>name</td>
      <td>CGG</td>
    </>
    // <Fragment>
    //   {items.map((item, index) => (
    //     <Fragment key={index}>{item}</Fragment>
    //   ))}
    // </Fragment>
  );
}
