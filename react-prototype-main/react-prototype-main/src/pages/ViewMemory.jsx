/*
Purpose: provide the page for viewing a single memory
Author: Luka Mitchell and Akira Fletcher.
Creation Date: 16th Sep.


*/
import React from 'react'
import { useState } from 'react'

const ViewMemory = (props) => {
  const [url, setUrl] = useState("https://t4.ftcdn.net/jpg/00/97/58/97/360_F_97589769_t45CqXyzjz0KXwoBZT9PRaWGHRk5hQqQ.jpg");
  const [alt, setAlt] = useState("Image not found");
  const [date, setdate] = useState("Enter Date");
  const [location, setLocation] = useState("Enter Location");
  const [descr, setDescr] = useState("Enter Description Here...");

  if (props.url != null && props.alt != null) {
    setUrl(props.url);
    setAlt(props.alt)
    // ...
  }

  return (
    <div className="w-full items-center justify-center p-5 bg-green-50 h-screen">
      <div className="w-full h-2/3 px-10 justify-center py-5">
        <img 
        className="border-2 drop-shadow-md rounded-3xl w-full h-full 
        bg-white object-contain"
        src={url}
        alt={alt}>
        </img>
      </div>
      <div className="flex px-10 w-100%">
        <>
          <span className="w-1/2">
            <p className="float-left bg-white border-2 drop-shadow-md rounded-2xl px-3">Date: {date}</p>
          </span>
          <span className="w-1/2">
            <p className="float-right bg-white border-2 drop-shadow-md rounded-2xl px-3">Location: {location}</p>
          </span>
        </>
      </div>
      <div className="h-1/3 px-10 py-5">
          <p className="h-full bg-white border-2 drop-shadow-md rounded-2xl px-3">{descr}</p>
        </div>
    </div>
  )
}

export default ViewMemory