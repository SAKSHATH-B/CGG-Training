import React from "react";
import { connect } from "react-redux";
import { buyCake } from "../redux";
import { buyIceCream } from "../redux/IceCream/iceCreamActions";

function ItemContainer(props) {
  return (
    <div>
      <h2>Items : {props.item}</h2>
      <button onClick={props.buyItem}>BuyItems</button>
    </div>
  );
}

const mapStateTopProps = (state, ownProps) => {
  const itemState = ownProps.cake
    ? state.cake.numOfCakes
    : state.iceCream.numOfIceCreams;

  return {
    item: itemState,
  };
};

const mapDispatchToProps = (dispatch, ownProps) => {
  const dispatchFunction = ownProps.cake
    ? () => dispatch(buyCake())
    : () => dispatch(buyIceCream());

  return {
    buyItem: dispatchFunction,
  };
};

export default connect(mapStateTopProps, mapDispatchToProps)(ItemContainer);
