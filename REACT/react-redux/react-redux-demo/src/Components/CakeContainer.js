import React from "react";
import { buyCake } from "../redux";
import { connect } from "react-redux";

export const CakeContainer = (props) => {
  return (
    <div>
      <h2>No of CAkes : {props.numOfCakes}</h2>
      <button onClick={props.buyCake}>buyCake</button>
    </div>
  );
};

const mapStateToProps = (state) => {
  return {
    numOfCakes: state.cake.numOfCakes,
  };
};
const mapDispatchToProps = (dispatch) => {
  return {
    buyCake: () => dispatch(buyCake()),
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(CakeContainer);
