import { Component } from "react";

class Welcome extends Component {
  render() {
    const { name, alias } = this.props;
    return (
      <h1>
        Welcome to react {name} a.k.a {alias}
      </h1>
    );
  }
}

export default Welcome;
