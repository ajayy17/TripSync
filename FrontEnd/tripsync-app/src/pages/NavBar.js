import React, { useEffect, useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import ApiContext from "../ApiContext.js";

const NavBar = () => {
  const navigate = useNavigate();
  const [logged, setLogged] = useState(false);
  const { value, setValue } = useContext(ApiContext);
  const LoginRegister = () => {
    navigate("/login");
  };

  const updateContext = (e) => {
    console.log(e.target.value);
    setValue(e.target.value);
  };
  useEffect(() => {
    // window.sessionStorage.setItem("token", res.data.data);
    // window.sessionStorage.setItem("email", email);
    // window.sessionStorage.getItem("token");
    //here we will check if logged or not
  }, []);
  return (
    <>
      <div>
        <div>
          <div>
            <button onClick={updateContext} value={"Flight"}>
              Flights
            </button>
          </div>
          <div>
            <button onClick={updateContext} value={"Hotel"}>
              Hotels
            </button>
          </div>
        </div>

        {!logged ? (
          <>
            <div>
              <button onClick={LoginRegister}>Login/Register</button>
            </div>
          </>
        ) : (
          <div></div>
        )}
      </div>
    </>
  );
};

export default NavBar;
