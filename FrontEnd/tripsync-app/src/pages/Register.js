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
    } catch (error) {
      setMessage(error.message);
    }
    console.log(message)
  };

  const LogIn = () => {
    navigate("/login");
  };

  return (
    <>
      <div className="loginHeader">
        <div>
          <h1>Register</h1>
          <div>
            <input
              type="text"
              placeholder="name"
              value={name}
              onChange={updateName}
            />
          </div>
        </div>
        <div>
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
          <button onClick={SignUp}>SingUp</button>
        </div>
        <div>
          <button onClick={LogIn}>LogIn</button>
        </div>
      </div>
    </>
  );
};

export default Register;
