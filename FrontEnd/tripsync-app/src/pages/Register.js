import React, { useState } from "react";
import "../styles/Login.css";
import { useNavigate } from "react-router-dom";

const Register = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("ROLE_USER");
  const [message, setMessage] = useState("");

  const navigate = useNavigate();

  const updateEmail = (e) => {
    setEmail(e.target.value);
  };

  const updatePassword = (e) => {
    setPassword(e.target.value);
  };
  const updateName = (e) => {
    setName(e.target.value);
  };

  const SignUp = async () => {
    try {
      const response = await fetch("http://localhost:9090/tripSync/api/registerUser", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          userName: name,
          email: email,
          password: password,
          role: role,
        }),
      });

      const data = await response.json();

      if (!response.ok) {
        throw new Error(data.message || "Registration failed");
      }

      setMessage("User registered successfully!");
      //navigating to home page
      navigate("/")
    } catch (error) {
      setMessage(error.message);
    }
  };

  const LogIn = () => {
    navigate("/login");
  };

  return (
    <>
      <div className="loginContainer">
        <div className="loginForm">
          <h1>Register</h1>
          <div className="form-group">
            <input
              type="text"
              placeholder="Name"
              value={name}
              onChange={updateName}
            />
          </div>
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
              onClick={SignUp}
              disabled={!name || !email || !password} // disables until filled
              className={name && email && password ? "active-btn" : "inactive-btn"}
            >
              SIGNUP
            </button>
        </div>
        <div className="form-group">
          <button className="sign-btn" onClick={LogIn}>LOGIN</button>
        </div>
        </div>
      </div>
    </>
  );
};

export default Register;
