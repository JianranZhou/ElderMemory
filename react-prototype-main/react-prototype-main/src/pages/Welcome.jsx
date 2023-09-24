/*
Purpose: Welcome Page as a confirmation to users for a successful sign up
Author: Luka Mitchell and Akira Fletcher
Creation Date: 27th Aug
*/

import React from 'react'
import { Link } from 'react-router-dom'

const Welcome = () => {

  const handleClick = () => {
    /* To be further implemented in the future */
    window.location.href = "/home";    
  }

  return (
    <div className="justify-center items-center p-5 h-screen">
      <div className="flex items-center flex-col p-3 h-full">
        <div className="border-solid border-slate-400 border-1 border-rounded 
        shadow-xl m-5 bg-white w-[30%]">
          <div className="flex p-0 mb-10 w-full justify-center 
          place-items-center flex">
            <h1 className="m-2 w-10/12 h-32 text-center text-2xl 
            font-bold pt-24">
               Welcome!
            </h1>
          </div>
          <div className="flex p-0 mb-10 w-full justify-center 
          place-items-center flex h-40">
            <button 
            className="border-1 border-gray-200 rounded-2xl 
            bg-[#2699FB] text-white font-bold px-3 py-1 m-5 w-5/12 h-14" 
            onClick={handleClick}>
              Done
            </button>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Welcome