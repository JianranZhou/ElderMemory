/*
Purpose: provide a webpage where users can enter details 
such as firstname, lastName, age, and gender, when signing up.
Author: Luka Mitchell and Akira Fletcher.
Creation Date: 27th Aug.
*/

import React from 'react'
import { useState } from 'react'

const EnterDetails = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [age, setAge] = useState("");
  const [gender, setGender] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    window.location.href = "/welcome";
  }

  return (
    <div className="justify-center items-center p-5 h-screen">
      <div className="flex items-center flex-col p-3">
        <div className="border-solid border-slate-400 border-1 border-rounded 
        shadow-xl m-5 bg-white w-[30%]">
          <div className="flex p-0 mb-10 w-full">
            <div className="w-full py-2 m-0">
              <p className="text-xl text-center">Sign Up</p>
            </div>
          </div>
          <form onSubmit={handleSubmit}>
            <div className="justify-center items-center flex">
              <input 
              type="text" 
              name="FirstName" 
              value={firstName} 
              placeholder="First Name"
              onChange={(e)=>setFirstName(e.target.value)} 
              className="border-2 border-gray-200 rounded-xl m-2 w-10/12 h-16 
              indent-2">
              </input>
            </div>
            <div className="justify-center items-center flex">
              <input 
              type="text" 
              name="LastName" 
              value={lastName} 
              placeholder="Last Name"
              onChange={(e)=>setLastName(e.target.value)} 
              className="border-2 border-gray-200 rounded-xl m-2 w-10/12 
              h-16 indent-2">
              </input>
            </div>
            <div className="flex items-center justify-center">
              <div className="w-11/12 flex">
                <div className="w-2/12 mx-2">
                  <input 
                  type="text" 
                  name="Age" 
                  value={age} 
                  placeholder="Age"
                  onChange={(e)=>setAge(e.target.value)} 
                  className="border-2 border-gray-200 rounded-xl m-2 w-11/12 
                  h-16 indent-2">
                  </input>
                </div>
                <div className="w-4/12 mx-2">
                  <input 
                  type="text" 
                  name="Gender" 
                  value={gender} 
                  placeholder="Gender"
                  onChange={(e)=>setGender(e.target.value)} 
                  className="border-2 border-gray-200 rounded-xl m-2 w-11/12 
                  h-16 indent-2">
                  </input>
                </div>
              </div>
            </div>
            <div className="justify-center items-center flex">
              <input 
              type="submit" 
              value="Next Step" 
              className="border-1 border-gray-200 rounded-2xl bg-[#2699FB] 
              text-white font-bold px-3 py-1 m-5 w-5/12 h-16">
              </input>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}

export default EnterDetails