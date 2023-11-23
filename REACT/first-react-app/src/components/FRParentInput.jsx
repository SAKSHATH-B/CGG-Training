import React, { Component } from "react";
import FrInput from "./FrInput";

export default class FRParentInput extends Component {
  constructor(props) {
    super(props);
    this.state = {};
    this.inputRef = React.createRef();
  }

  clickHandler = () => {
    this.inputRef.current.focus();
  };

  render() {
    return (
      <div>
        <FrInput ref={this.inputRef} />

        <button onClick={this.clickHandler}>Focus Input</button>
      </div>
    );
  }
}
