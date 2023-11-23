import "./App.css";
import React from "react";
import { Route, Routes } from "react-router-dom";
import { HomePage } from "./Components/HomePage";
// import AboutPage from "./Components/AboutPage";
import { Navbar } from "./Components/Navbar";
import { OrderSummary } from "./Components/OrderSummary";
import { Products } from "./Components/Products";
import { FeaturedProducts } from "./Components/FeaturedProducts";
import { NewProducts } from "./Components/NewProducts";
import { PageNotFound } from "./Components/PageNotFound";
import { Users } from "./Components/Users";
import { UserDetails } from "./Components/UserDetails";
import { Admin } from "./Components/Admin";
const LazyAbout = React.lazy(() => import("./Components/AboutPage"));

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route
          path="about"
          element={
            <React.Suspense fallback="Loading...">
              <LazyAbout />
            </React.Suspense>
          }
        />
        <Route path="order-summary" element={<OrderSummary />} />
        <Route path="products" element={<Products />}>
          <Route index element={<FeaturedProducts />} />
          <Route path="featured" element={<FeaturedProducts />} />
          <Route path="new" element={<NewProducts />} />
        </Route>
        <Route path="users" element={<Users />}>
          <Route path=":Id" element={<UserDetails />} />
          <Route path="admin" element={<Admin />} />
        </Route>
        <Route path="*" element={<PageNotFound />} />
      </Routes>
    </>
  );
}

export default App;
