import { Col, Container, Row } from "reactstrap";
import Base from "../Components/Base";
import CategorySideMenu from "../Components/CategorySideMenu";
import CustomNavbar from "../Components/CustomNavbar";
import NewsFeed from "../Components/NewsFeed";

const Home = () => {
  return (
    <Base>
      <Container className="mt-3">
        <Row>
          <Col md={2} className="pt-5">
            <CategorySideMenu />
          </Col>
          <Col md={3}>
            <NewsFeed />
          </Col>
        </Row>
      </Container>
      <CustomNavbar />
    </Base>
  );
};

export default Home;
