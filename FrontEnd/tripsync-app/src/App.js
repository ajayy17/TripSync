import "./styles/App.css";
import { useState } from "react";
import Login from "./pages/Login";
import Register from "./pages/Register";
import Home from "./pages/Home";
import { Route, Routes, BrowserRouter } from "react-router-dom";
import NavBar from "./components/NavBar.js";
import ApiContext from "./contexts/ApiContext.js";
import { AuthProvider } from "./contexts/AuthContext.js";
import Flights from "./pages/Flights.js";

function App() {
  const [status, setStatus] = useState("");
  return (
    <ApiContext.Provider value={{ value: status, setValue: setStatus }}>
      <AuthProvider>
      <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={
              <div>
                <NavBar />
                <Home />
              </div>
            }
          />
          <Route path="/Flights" element={<Flights />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </BrowserRouter>
      </AuthProvider>
    </ApiContext.Provider>
  );
}

export default App;
