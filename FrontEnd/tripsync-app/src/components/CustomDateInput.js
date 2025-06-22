import React from "react";
import { FaChevronDown } from "react-icons/fa";

const CustomDateInput = React.forwardRef(({ value, onClick, placeholder }, ref) => (
  <input
    className="custom-datepicker-input"
    onClick={onClick}
    ref={ref}
    value={value}
    readOnly
    placeholder={placeholder}
  />
));

export default CustomDateInput;