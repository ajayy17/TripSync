import React, { Suspense, useContext, useEffect, useState } from "react";
import ApiContext from "../ApiContext.js";

const LazyFlight = React.lazy(() => import("./FlightSearch"));
const LazyHotel = React.lazy(() => import("./HotelSearch"));
const Home = () => {
  const value = useContext(ApiContext);

  return (
    <div>
      {value.value === "Flight" && (
        <Suspense fallback={<div>Loading Flight...</div>}>
          <LazyFlight />
        </Suspense>
      )}
      {value.value === "Hotel" && (
        <Suspense fallback={<div>Loading Hotel...</div>}>
          <LazyHotel />
        </Suspense>
      )}
    </div>
  );
};

export default Home;
