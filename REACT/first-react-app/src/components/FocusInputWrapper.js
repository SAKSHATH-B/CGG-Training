import React from "react";
import { Component } from "react";
import { Input } from "./Input";

export class FocusInputWrapper extends Component {
  constructor() {
    super();
    this.componentRef = React.createRef();
  }
  clickHandler = () => {
    this.componentRef.current.focusInput();
  };
  render() {
    return (
      <div>
        <Input ref={this.componentRef} />
        <button onClick={this.clickHandler}>Focus Input</button>
      </div>
    );
  }
}
