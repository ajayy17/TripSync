import React, { useEffect, useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import ApiContext from "../contexts/ApiContext.js";
import "../styles/Navbar.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faPlane, faHotel } from "@fortawesome/free-solid-svg-icons";
import { faUser } from "@fortawesome/free-solid-svg-icons";
import { useAuth } from "../contexts/AuthContext.js";

const NavBar = () => {
  const navigate = useNavigate();
  const { logged, setLogged } = useAuth();
  const { value, setValue } = useContext(ApiContext);

  const LoginRegister = () => {
    navigate("/login");
  };

  const Logout = () => {
    localStorage.removeItem("token");
    navigate("/login");
  };
  // useEffect(() => {}, [value]);

  return (
    <div className="navbar">
      <h1 className="logo">
        <span className="trip">trip</span>
        <span className="sync">sync</span>
      </h1>

      <div className="nav-buttons">
        <button onClick={()=>{setValue("Flight")}}>
          <FontAwesomeIcon icon={faPlane} className="nav-icon flight-icon" />
          <div>Flights</div>
        </button>

        <button onClick={()=>{setValue("Hotel")}}>
          <FontAwesomeIcon icon={faHotel} className="nav-icon hotel-icon" />
          <div>Hotels</div>
        </button>

        <div className="navbar-end">
          <div className="login-box">
            {!logged ? (
              <button onClick={LoginRegister}>
                <FontAwesomeIcon icon={faUser} className="login-icon" />
                <span className="login-text">Login/Register</span>
              </button>
            ) : (
              <button onClick={Logout}>
                <FontAwesomeIcon icon={faUser} className="login-icon" />
                <span className="login-text">Logout</span>
              </button>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};
export default NavBar;
