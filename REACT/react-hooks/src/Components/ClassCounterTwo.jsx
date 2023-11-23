import React, { Component } from "react";

export default class ClassCounterTwo extends Component {
  constructor(props) {
    super(props);

    this.state = {
      count: 0,
    };
  }
  clickHandler = () => {
    this.setState((prevState) => ({ count: prevState.count + 1 }));
  };
  render() {
    return (
      <div>
        <button onClick={this.clickHandler}>Clicked {this.state.count}</button>
      </div>
    );
  }
}
