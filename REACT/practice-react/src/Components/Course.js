import {
  Button,
  Card,
  CardBody,
  CardSubtitle,
  CardText,
  Container,
} from "reactstrap";
import React from "react";

export const Course = ({ courses }) => {
  return (
    <Card>
      <CardBody>
        <CardSubtitle style={{ fontWeight: "bold" }}>
          {courses.title}
        </CardSubtitle>
        <CardText>{courses.desc}</CardText>
        <Container>
          <Button color="warning" style={{ marginRight: "5px" }}>
            Update
          </Button>
          <Button color="danger">Delete</Button>
        </Container>
      </CardBody>
    </Card>
  );
};
