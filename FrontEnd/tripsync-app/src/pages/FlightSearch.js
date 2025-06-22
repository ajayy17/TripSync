import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import CustomDateInput from '../components/CustomDateInput'
import '../styles/FlightSearch.css'

const FlightSearch = () => {
  const [selectedOption, setSelectedOption] = useState("oneWay");
  const [departureDate, setDepartureDate] = useState(new Date());
  const [returnDate, setReturnDate] = useState(new Date());
  const [fromCityAirport, setFromCityAirport]=useState();
  const [toCityAirport, setToCityAirport]=useState();
  const [totalPassengers, setTotalPassengers]=useState(0);
  
  const searchDetails={departureDate:departureDate,returnDate:returnDate,fromCityAirport:fromCityAirport,toCityAirport:toCityAirport,totalPassengers:totalPassengers};
  const navigate = useNavigate();
  

  const handleChange = (e) => {
    setSelectedOption(e.target.value);
    console.log("Selected:", e.target.value);
  };

  const handleReturnClick = () => {
    setSelectedOption("roundTrip");
  };

  const searchFlights = () => {
      console.log("/Flights")
      navigate("/flights",{state:{searchDetails}});
  }
  return (
  <div>
    <div className="orange-banner"></div>
    <div className="flight-search-container">
      <h2 className="flight-title">Book Domestic and International Flight Tickets</h2>

      <div className="flight-type-options">
        <label className="flight-type-option">
          <input
            type="radio"
            name="flightType"
            value="oneWay"
            checked={selectedOption === "oneWay"}
            onChange={handleChange}
          />
          <span>One-way</span>
        </label>
        <label className="flight-type-option">
          <input
            type="radio"
            name="flightType"
            value="roundTrip"
            checked={selectedOption === "roundTrip"}
            onChange={handleChange}
          />
          <span>Round-trip</span>
        </label>
      </div>

      <div className="flight-input-grid">
        <div className="input-box">
          <span>From</span>
          <input type="text" placeholder="Enter city or airport" onChange={()=>{setFromCityAirport(e.target.value)}} />
        </div>
        <div className="input-box">
          <span>To</span>
          <input type="text" placeholder="Enter city or airport" onChange={()=>{setToCityAirport(e.target.value)}}/>
        </div>
        <div className="input-box">
          <span>Departure</span>
          <DatePicker
            selected={departureDate}
            onChange={(date) => setDepartureDate(date)}
            customInput={<CustomDateInput />}
            placeholderText="Departure Date"
          />
        </div>
        <div className="input-box">
          <span>Return</span>
          {selectedOption === "oneWay" ? (
            <input
              type="text"
              placeholder="Click to add a return flight for better discounts"
              onFocus={handleReturnClick}
            />
          ) : (
            <DatePicker
              selected={returnDate}
              onChange={(date) => setReturnDate(date)}
              customInput={<CustomDateInput />}
              placeholderText="Return Date"
            />
          )}
        </div>
        <div className="input-box">
          <span>Travellers & Class</span>
          <input type="text" placeholder="1 Adult, Economy" onChange={()=>{setTotalPassengers(e.target.value)}}/>
        </div>
      </div>

      <div className="search-button-container">
        <button className="search-button" onClick={searchFlights}>SEARCH FLIGHTS</button>
      </div>
    </div>
  </div>
);

};

export default FlightSearch;
