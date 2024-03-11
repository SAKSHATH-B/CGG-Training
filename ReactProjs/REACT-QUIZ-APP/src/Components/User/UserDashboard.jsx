import React, { useState } from "react";
import { AwesomeButton } from "react-awesome-button";
import { useNavigate } from "react-router-dom";
import { Col, Container, Row } from "reactstrap";
import Sidebar from "../Admin/Sidebar";
import CustomNavbar from "../CustomNavbar";
import { getAllCategories } from "../Helper/QuizHelper";
import UserSidebar from "../Admin/Users/UserSidebar";
import { Fab } from "@mui/material";

const UserDashboard = () => {
  const text = "WELCOME TO USER DASHBOARD ".split(",");
  const [showWelcomeMessage, setShowWelcomeMessage] = useState(true);
  const [showCategorySelection, setShowCategorySelection] = useState(false);
  const categories = ["react", "java", "spring", "firebase"];

  const [fetchedCategory, setFetchedCategory] = useState([]);

  const navigate = useNavigate();

  const takequiz = (each) => {
    console.log("suddkj");
    navigate("/user/takequiz", {
      state: { categoryName: each },
    });
  };

  useState(() => {
    getAllCategories().then((categoryArray) => {
      setFetchedCategory(categoryArray);
    });
  });
  return (
    <>
      <CustomNavbar />
      <Container fluid>
        <Row>
          {/* <Col sm="3" md="2" className="sidebar p-0 fadeleft  ">
            <UserSidebar />
          </Col> */}
          <Col>
            <Container>
              <Row className="sidebar">
                <Col md={6}>
                  <div>
                    <b>&nbsp; AVAILABLE QUIZ</b>

                    <h3 className="mt-3 "></h3>
                  </div>
                  {fetchedCategory &&
                    fetchedCategory.map((each, index) => {
                      return (
                        <>
                          <div className="fader border border-grey rounded p-3  mb-2 shadow-lg  bg-white   ">
                            <h5>
                              {index + 1}.{each}
                            </h5>

                            <AwesomeButton
                              onPress={() => takequiz(each)}
                              className="me-2 "
                              type="linkedin"
                            >
                              Take Quiz
                            </AwesomeButton>
                            {/* <Fab size="large" className="  rounded-0    "> */}
                            {/* ss */}
                            {/* </Fab> */}
                          </div>
                        </>
                      );
                    })}
                </Col>
                <Col md={6}>
                  <div>
                    <h3 className="mt-3 ">
                      <b>&nbsp; COMPLETED QUIZ</b>
                    </h3>
                    <>
                      <div className=" fader border border-grey rounded p-3  mb-2 shadow-lg  bg-white   ">
                        <h5>1.Hibernate</h5>
                        <h6>
                          <b>Result</b> : Pending &nbsp;
                          <i
                            class="fa-regular fa-hourglass-half"
                            // style={{ color: "navy" }}
                          ></i>
                        </h6>
                      </div>
                      <div className=" fader border border-grey rounded p-3  mb-2 shadow-lg  bg-white   ">
                        <h5>2.python</h5>
                        <h6>
                          <b>Result</b> : passed &nbsp;
                          <i
                            class="fa-solid fa-check"
                            style={{ color: "green" }}
                          ></i>
                        </h6>
                      </div>
                      <div className=" fader border border-grey rounded p-3  mb-2 shadow-lg  bg-white   ">
                        <h5>2.Microservices</h5>
                        <h6>
                          <b>Result</b> : failed &nbsp;
                          <i
                            class="fa-solid fa-xmark"
                            style={{ color: "red" }}
                          ></i>
                        </h6>
                      </div>
                    </>
                  </div>
                </Col>
              </Row>
            </Container>
          </Col>
        </Row>
      </Container>
    </>
  );
};

export default UserDashboard;
