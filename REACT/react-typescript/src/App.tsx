import "./App.css";
import { Private } from "./Components/auth/Private";
import { Profile } from "./Components/auth/Profile";
import Counter from "./Components/class/Counter";
import { Box } from "./Components/context/Box";
import { ThemeContextProvider } from "./Components/context/ThemeContext";
import { List } from "./Components/generics/List";
import { DomRef } from "./Components/ref/DomRef";
import { MutableRef } from "./Components/ref/MutableRef";
import { RandomNumber } from "./Components/restriction/RandomNumber";
// import { Counter } from "./Components/state/Counter";
// import { Container } from "./Components/Container";
// import { LoggedIn } from "./Components/state/LoggedIn";
// import { User } from "./Components/state/User";
// import { Button } from "./Components/Button";
// import { Inputs } from "./Components/Inputs";
// import { Heading } from "./Components/Heading";
// import { Oscar } from "./Components/Oscar";
// import { PersonList } from "./Components/PersonList";
// import { Status } from "./Components/Status";
// import { Greet } from "./Components/Greet";
// import { Person } from "./Components/Person";

function App() {
  // const personName = {
  //   firstName: "Mahesh",
  //   lastName: "Babu",
  // };

  // const namesList = [
  //   {
  //     firstName: "Ajay",
  //     lastName: "Kukatla",
  //   },
  //   {
  //     firstName: "Madhav",
  //     lastName: "Kudire",
  //   },
  //   {
  //     firstName: "Arvind",
  //     lastName: "Gade",
  //   },
  //   {
  //     firstName: "Charan",
  //     lastName: "Rachakonda",
  //   },
  //   {
  //     firstName: "Sakshath",
  //     lastName: "Banavath",
  //   },
  // ];
  return (
    <div>
      {/* <Greet name="Ajay Kukatla" isLoggedIn={true} /> */}
      {/* <Person name={personName} /> */}
      {/* <PersonList names={namesList} /> */}
      {/* <Status status="loading" /> */}
      {/* <Heading>Hello This is a heading text</Heading>
      <Oscar>
        <Heading>This is a heading text in Oscar Component</Heading>
      </Oscar> */}
      {/* <Button
        handleClick={(event, id) => {
          console.log("Button Clicked", event, id);
        }}
      />
      <Inputs
        value=""
        handleChange={(e) => {
          console.log(e.target.value);
        }}
      /> */}

      {/* <Container style={{ border: "1px solid black", padding: "1rem" }} /> */}
      {/* <LoggedIn /> */}
      {/* <User /> */}
      {/* <Counter /> */}
      {/* <ThemeContextProvider>
        <Box />
      </ThemeContextProvider> */}
      {/* <DomRef /> */}
      {/* <MutableRef /> */}
      {/* <Counter /> */}
      {/* <Private isLoggedIn={true} component={Profile} /> */}
      <List
        items={["BMW", "Ferrari", "Porsche", "Audi"]}
        onClick={(item) => console.log(item)}
      />
      <List items={[1, 2, 3]} onClick={(item) => console.log(item)} />
      <List
        items={[
          {
            first: "Mark",
            last: "antony",
          },
          {
            first: "Tony",
            last: "Stark",
          },
          {
            first: "Mr.",
            last: "Bean",
          },
        ]}
        onClick={(item) => console.log(item)}
      />
      {/* <RandomNumber value={21} isNegative /> */}
    </div>
  );
}

export default App;
