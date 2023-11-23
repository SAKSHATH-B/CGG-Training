import React, { Component } from "react";
// import PureComp from "./PureComp";
// import RegularComp from "./RegularComp";
import MemoComp from "./MemoComp";

export default class ParentComp extends Component /*PureComponent */ {
  constructor(props) {
    super(props);
    this.state = { name: "CGG" };
  }

  componentDidMount() {
    setInterval(() => {
      this.setState({
        name: "CGG",
      });
    }, 2000);
  }

  render() {
    console.log("************** parent comp render ***************");
    return (
      <div>
        ParentComp
        {/* <PureComp name={this.state.name} />
        <RegularComp name={this.state.name} /> */}
        <MemoComp name={this.state.name} />
      </div>
    );
  }
}
