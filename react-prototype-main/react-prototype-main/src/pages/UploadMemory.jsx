/*
Purpose: provide the page for viewing a single memory
Author: Luka Mitchell and Akira Fletcher.
Creation Date: 16th Sep.


*/
import React from 'react'
import { useState } from 'react'
import MemoryImage from '../components/MemoryImage';

const UploadMemory = () => {
  const [url, setUrl] = useState("");
  const [alt, setAlt] = useState("Image not found");
  const [date, setDate] = useState("");
  const [location, setLocation] = useState("");
  const [descr, setDescr] = useState("");

  return (
    <div className="w-full justify-center flex p-5 bg-green-50 h-full">
      <div className="w-2/3 h-full px-10 items-center float-center py-5 bg-white border-2 rounded-2xl">
        <MemoryImage 
        url={url}
        alt={alt}>
        </MemoryImage>
        <div className="py-2 flex items-center justify-center">
          <p className="h-full justify-center">Click on the + to upload a new memory</p>
        </div>
        <form className="pb-0 h-full mb-0">
          <>
            <span className="w-1/2">
              <input
              type="text" 
              name="Date" 
              value={date} 
              placeholder="Enter Date"
              onChange={(e)=>setDate(e.target.value)}
              className="float-left bg-white border-2 drop-shadow-md rounded-2xl px-3">
              </input>
            </span>
            <span className="w-1/2">
              <input
              type="text" 
              name="Location" 
              value={location} 
              placeholder="Enter Location"
              onChange={(e)=>setLocation(e.target.value)}
              className="float-right bg-white border-2 drop-shadow-md rounded-2xl px-3">
              </input>
            </span>
          </>
          <div className="pt-9 pb-5">
            <textarea
            type="text" 
            name="Description" 
            value={descr} 
            placeholder="Enter Description"
            onChange={(e)=>setDescr(e.target.value)}
            className="w-full h-20 bg-white border-2 drop-shadow-md rounded-2xl px-3">
            </textarea>
          </div>
          <div className="justify-center items-center pb-0 h-10 flex">
            <input 
            type="submit" 
            value="Upload Memory" 
            className="drop-shadow-md rounded-3xl bg-[#2699FB] 
            text-white font-bold px-3 m-5 w-4/12 h-10">
            </input>
          </div>
        </form>
      </div>
    </div>
  )
}

export default UploadMemory