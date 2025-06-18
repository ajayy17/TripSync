import React, { useState } from "react";

const Register = () => {
  const [email, setEmail] = useState("");

  const [password, setPassword] = useState("");
  const [name, setName] = useState("");

  const updateEmail = (e) => {
    setEmail(e.target.value);
  };

  const updatePassword = (e) => {
    setPassword(e.target.value);
  };
  const updateName = (e) => {
    setName(e.target.value);
  };

  const SignUp = () => {
    //Call the api and pass the data
  };

  return (
    <>
      <div>
        <div>
          <h1>Register</h1>
          <div>
            <h3>Enter your Name</h3>
            <input type="text" onChange={updateName} />
          </div>
        </div>
        <div>
          <h1>Email</h1>
          <div>
            <h3>Enter your Email</h3>
            <input type="text" onChange={updateEmail} />
          </div>
        </div>
        <div>
          <h1>Password</h1>
          <div>
            <h3>Enter your password</h3>
            <input type="text" onChange={updatePassword} />
          </div>
        </div>
        <div>
          <button onClick={SignUp}>SingUp</button>
        </div>
      </div>
    </>
  );
};

export default Register;

// name email password
