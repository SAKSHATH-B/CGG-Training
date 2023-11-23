import React from "react";
import { Alert, Button, Container } from "reactstrap";

export const Home = () => {
  return (
    <div>
      <Alert>
        <h1>Learning ReactJS in CGG Hyderabad</h1>
        <p>I am a Trainee Software Developer learning React</p>
        <Container>
          <Button>Click Me</Button>
        </Container>
      </Alert>
    </div>
  );
};
