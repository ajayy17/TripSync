import "./styles/App.css";
import { useState } from "react";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Home from "./pages/Home";
import { Route, Routes, BrowserRouter } from "react-router-dom";
import NavBar from "./pages/NavBar";
import ApiContext from "./ApiContext.js";

function App() {
  const [status, setStatus] = useState("Flight");
  return (
    <ApiContext.Provider value={{ value: status, setValue: setStatus }}>
      <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={
              <div>
                <Home />
                <NavBar />
              </div>
            }
          />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </BrowserRouter>
    </ApiContext.Provider>
  );
}

export default App;
