import React, { Suspense, useContext, useEffect, useState } from "react";
import ApiContext from "../contexts/ApiContext.js";
import { useNavigate } from "react-router-dom";
import Loader from "../components/Loader.js";

const LazyFlight = React.lazy(() => import("./FlightSearch"));
const LazyHotel = React.lazy(() => import("./HotelSearch"));
const LazyWelcome = React.lazy(() => import("./WelcomeScreen.js"))
const Home = () => {
  const value = useContext(ApiContext);
  const navigate = useNavigate();
  
  const Login = () => {
    navigate("/register");
  };

  return (
    <div>
     <div>
      { value.value === "" && (
        <Suspense fallback = {<Loader />}>
          <LazyWelcome />
        </Suspense>
      )}
      {value.value === "Flight" && (
        <Suspense fallback={<Loader />}>
          <LazyFlight />
        </Suspense>
      )}
      {value.value === "Hotel" && (
        <Suspense fallback={<Loader />}>
          <LazyHotel />
        </Suspense>
      )}
    </div>
     
    </div>
  );
};

export default Home;
