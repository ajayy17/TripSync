import React from 'react'
import { createContext, useContext, useEffect, useState } from "react";

//Create context
const AuthContext = createContext({
    logged: false,
    setLogged:() =>{}
})

//Auth Provider
export const AuthProvider = ({children}) => {
    const [logged, setLogged] = useState(false);

    useEffect(() =>{
        const token = localStorage.getItem("token")

        //set the login status true or false according to token is in local storage or not
        setLogged(!!token);
    }, [])

    return (
    <AuthContext.Provider value={{ logged, setLogged }}>
      {children}
    </AuthContext.Provider>
  );
}

// Hook to use the context
export const useAuth = () => useContext(AuthContext);