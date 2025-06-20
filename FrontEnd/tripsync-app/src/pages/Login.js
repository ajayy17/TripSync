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
      <div className="loginHeader">
        <div>
          <h1>Login</h1>
          <div>
            <input
              type="text"
              placeholder="email"
              value={email}
              onChange={updateEmail}
            />
          </div>
        </div>
        <div>
          <div>
            <input
              type="password"
              placeholder="password"
              value={password}
              onChange={updatePassword}
            />
          </div>
        </div>
        <div>
          <button onClick={LogIn}>Login</button>
        </div>
        <div>
          <button onClick={SignUp}>SignUp</button>
        </div>
      </div>
    </>
  );
};

export default Login;
