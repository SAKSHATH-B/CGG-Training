import React, { Component } from "react";

export default class CounterRenderProps extends Component {
  constructor(props) {
    super(props);

    this.state = {
      count: 0,
    };
  }

  incrementCount = () => {
    this.setState((prevState) => ({
      count: prevState.count + 1,
    }));
  };
  render() {
    return (
      <div>
        {/* {this.props.render(this.state.count, this.incrementCount)} */}
        {this.props.children(this.state.count, this.incrementCount)}
      </div>
    );
  }
}
