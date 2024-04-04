import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import "./index.css";
import { Auth0Provider } from "@auth0/auth0-react";

import "bootstrap/dist/css/bootstrap.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../node_modules/bootstrap/dist/js/bootstrap.min.js";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <Auth0Provider
      domain="dev-xgrz7fos8c1sl8s6.us.auth0.com"
      clientId="LprB9yBLGxZqf3wadMhzq55B9xi5QZeH"
    >
      <App />
    </Auth0Provider>
  </React.StrictMode>
);
