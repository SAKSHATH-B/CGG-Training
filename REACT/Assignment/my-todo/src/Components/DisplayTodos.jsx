import React from "react";
import { Button, Card, Col, Container, ListGroup, Row } from "react-bootstrap";
import { clearTodo, deleteTodo } from "../redux/action/todo";
import DisplayCount from "./DisplayCount";
import { connect } from "react-redux";

const DisplayTodos = ({ todos, clearTodo, deleteTodo }) => {
  return (
    <Container>
      <Row>
        <Col>
          <Card className="mt-3 shadow-sm">
            <Card.Body>
              <h3>All todos are here</h3>
              <Button onClick={clearTodo} variant="danger" size="sm">
                Clear
              </Button>
              <DisplayCount />
              <ListGroup>
                {todos.map((todo, index) => (
                  <ListGroup.Item key={index}>
                    <h4>{todo.title}</h4>
                    <p>{todo.description}</p>
                    <Button
                      onClick={(e) => deleteTodo(todo.id)}
                      variant="danger"
                      size="sm"
                    >
                      Delete
                    </Button>
                  </ListGroup.Item>
                ))}
              </ListGroup>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

const mapStateToProps = (state) => {
  console.log(state);
  return { todos: state.todos };
};
const mapDispatchToProps = (dispatch) => ({
  deleteTodo: (id) => dispatch(deleteTodo(id)),
  clearTodo: () => dispatch(clearTodo()),
});
export default connect(mapStateToProps, mapDispatchToProps)(DisplayTodos);
