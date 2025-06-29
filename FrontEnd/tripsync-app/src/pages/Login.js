import React, { useState } from "react";
import "../styles/Login.css";
import Register from "./Register";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const navigate = useNavigate();

  const updateEmail = (e) => {
    setEmail(e.target.value);
  };

  const updatePassword = (e) => {
    setPassword(e.target.value);
  };

  const LogIn = async () => {
    try {
      const response = await fetch(
        "http://localhost:9090/tripSync/api/auth/signin",
        {
          method: "POST",
          headers: {
            "content-type": "application/json",
          },
          body: JSON.stringify({
            username: email,
            password: password,
          }),
        }
      );

      const data = await response.json();

      if (!response.ok) {
        throw new Error(data.message || "Login Failed");
      }

      localStorage.setItem("token", data.jwtToken);
      setMessage("Successfully Logged In");

      //navigating to home page
      navigate("/");
    } catch (error) {
      setMessage(error.message);
    }
    console.log(message);
  };
  const SignUp = () => {
    navigate("/register");
  };
  return (
    <>
      <div className="loginContainer">
        <div className="loginForm">
          <h1>Login</h1>
          <div className="form-group">
            <input
              type="text"
              placeholder="Email"
              value={email}
              onChange={updateEmail}
            />
          </div>
          <div className="form-group">
            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={updatePassword}
            />
          </div>
          <div className="form-group">
            <button
              onClick={LogIn}
              disabled={!email || !password} // disables until filled
              className={email && password ? "active-btn" : "inactive-btn"}
            >
              LOGIN
            </button>
          </div>
          <div className="form-group">
            <button className="sign-btn" onClick={SignUp}>SIGNUP</button>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;
