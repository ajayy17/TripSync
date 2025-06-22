import React from "react";
import '../styles/WelcomeScreen.css'
import welcomeImage from "../images/welcome-traveller.dd439bfa.png";
import { useNavigate } from "react-router-dom";

const WelcomeScreen = () => {
    const navigate = useNavigate();

    const Login = () => {
        navigate("/login")
    }
  return (
    <div>
      <div className="home-container">
        <div className="orange-banner"></div>
        <div className="welcome-section">
          <div className="welcome-text">
            <h2>Welcome, Traveller!</h2>
            <p>
              Login to get access to your goCash, profile & bookings, and stay
              updated on the best travel offers.
            </p>
            <button className="login-btn" onClick={Login}>
              LOGIN
            </button>
          </div>
          <div className="welcome-image">
            <img src={welcomeImage} alt="Welcome Traveller" />
          </div>
        </div>
      </div>
    </div>
  );
};

export default WelcomeScreen;
