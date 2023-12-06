import React, { useState } from "react";
import Base from "../Components/Base";
import {
  Button,
  Card,
  CardBody,
  CardHeader,
  Col,
  Container,
  FormGroup,
  Row,
} from "reactstrap";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useNavigate } from "react-router-dom";
import { userLogin } from "../services/user-services";
import { doLogin } from "../auth";

const Login = () => {
  const navigate = useNavigate();

  const [login, setLogin] = useState({
    username: "",
    password: "",
  });

  const handleChange = (e, property) => {
    setLogin({ ...login, [property]: e.target.value });
  };

  const handleReset = () => {
    setLogin({
      username: "",
      password: "",
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(login);
    if (login.username.trim() == "" || login.password == "") {
      toast.error("Username or Password is required!!");
      return;
    }

    //submit data to server to generate token
    userLogin(login)
      .then((data) => {
        console.log(data);
        //save data to localStorage
        doLogin(data, () => {
          console.log("Login details is saved to localStorage");
          //redirect to user dashboard
          navigate("/user/dashboard");
        });
        toast.success("Login Success");
      })
      .catch((error) => {
        console.log(error);
        if (error.response.status == 400 || error.response.status == 404) {
          toast.error(error.response.data.message);
        } else {
          toast.error("Something went wrong on server");
        }
      });

    setLogin({
      username: "",
      password: "",
    });
  };

  return (
    <Base>
      <Container>
        <Row className="mt-4">
          <Col sm={{ size: 6, offset: 3 }}>
            <Card color="dark" inverse>
              <CardHeader>
                <h3>Login Here!!</h3>
              </CardHeader>
              <CardBody>
                <form onSubmit={handleSubmit}>
                  {/*Email field*/}
                  <FormGroup>
                    <label htmlFor="email">Enter Email</label>
                    <input
                      type="email"
                      id="email"
                      value={login.username}
                      onChange={(e) => handleChange(e, "username")}
                    />
                  </FormGroup>
                  <FormGroup>
                    <label htmlFor="password">Enter Password</label>
                    <input
                      type="password"
                      id="password"
                      value={login.password}
                      onChange={(e) => handleChange(e, "password")}
                    />
                  </FormGroup>
                  <Container className="text-center">
                    <Button color="light" outline type="submit">
                      Login
                    </Button>
                    <Button
                      onClick={handleReset}
                      className="ms-2"
                      outline-color="secondary"
                    >
                      Reset
                    </Button>
                  </Container>
                </form>
              </CardBody>
            </Card>
          </Col>
        </Row>
      </Container>
    </Base>
  );
};

export default Login;
