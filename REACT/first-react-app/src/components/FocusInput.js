import React, { Component, Fragment } from "react";
export class FocusInput extends Component {
  constructor() {
    super();
    this.inputRef = React.createRef();
    // 1.
    this.cbRef = null;
    // 2.
    this.setCbRef = (element) => (this.cbRef = element);
  }

  componentDidMount() {
    this.inputRef.current.focus();

    if (this.cbRef) {
      this.cbRef.focus();
    }
  }

  render() {
    return (
      <Fragment>
        <input type="text" name="" id="" ref={this.inputRef} />
        <input type="text" name="" id="" ref={this.setCbRef} />
      </Fragment>
    );
  }
}
