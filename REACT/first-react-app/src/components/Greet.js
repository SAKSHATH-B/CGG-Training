// const Greet = ({ name, company, children }) => {
//   return (
//     <div>
//       <h1>
//         Greetings I am {name} from {company}
//         {children}
//       </h1>
//     </div>
//   );
// };
// export default Greet;

// const Greet = (props) => {
//   console.log(props);
//   return (
//     <div>
//       <h1>
//         Greetings I am {props.name} from {props.company}
//         {props.children}
//       </h1>
//     </div>
//   );
// };
// export default Greet;

//destructuring
const Greet = (props) => {
  console.log(props);
  const { name, company, children } = props;
  return (
    <div>
      <h1>
        Greetings I am {name} from {company}
        {children}
      </h1>
    </div>
  );
};
export default Greet;
