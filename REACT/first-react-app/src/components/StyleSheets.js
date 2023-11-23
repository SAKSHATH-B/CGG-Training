import "./myStyles.css";

export const StyleSheets = (props) => {
  let className = props.primary ? "primary" : ""; //conditional passing
  return <h1 className={`${className} font-xl`}>StyleSheets</h1>;
};
