import { Component } from "react";

type ClassState = {
  count: number;
};

export default class Counter extends Component<{}, ClassState> {
  state = {
    count: 0,
  };

  btnHandler = () => {
    this.setState((prevState) => ({ count: prevState.count + 1 }));
  };

  render() {
    return (
      <div>
        <button onClick={this.btnHandler}>
          CLicked {this.state.count} times
        </button>
      </div>
    );
  }
}
