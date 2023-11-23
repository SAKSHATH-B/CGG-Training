import logo from "./logo.svg";
import "./App.css";
import { Header } from "./Components/Header";
import { Button } from "reactstrap";
import { ToastContainer, toast } from "react-toastify";
import { Home } from "./Components/Home";
import { Course } from "./Components/Course";
import { AllCourses } from "./Components/AllCourses";

function App() {
  const btnHandle = () => {
    toast("This is my react message from toast");
    toast.success("Hurray");
  };
  return (
    <div className="App">
      {/* <Header name="Sakshath" title="Fast and Furious X" />
      <hr />
      <Header name="Dinakar" title="Tony Stark the Iron Man" />
      <hr /> */}
      <h1>HELLO HYDERABAD</h1>
      <p>I am Currently at Centre for Good Governance Gachibowli</p>

      {/* <h1>This is BootStrap Components in reactstrap</h1>
      <Button className="bg-dark text-danger">Submit</Button> */}

      {/* <ToastContainer />
      <Button outline color="danger" onClick={btnHandle}>
        Press Here for Magic
      </Button> */}

      {/* <Home /> */}

      {/* <Course
        courses={{
          title: "JavaScript",
          desc: "Hands on Practice on JavaScript",
        }}
      />
      <Course
        courses={{ title: "ReactJS", desc: "Hands on Practice on ReactJS" }}
      /> */}

      <AllCourses />
    </div>
  );
}

export default App;
