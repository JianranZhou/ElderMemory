/*
Purpose: Photocard component for the Main Page
Author: Luka Mitchell and Akira Fletcher
Creation Date: 25th Aug
*/

import React from 'react'

/* Takes the properties of the photo cards (text, url, etc.) to display
relevant information on the home page*/
const PhotoCards = (props) => {
  return (
    <div className="w-3/12 p-5 pt-16 m-10">
      <div className="font-serif text-lg text-slate-500 text-center p-3">
        <h2>
          {props.text}
        </h2>
      </div>
      <div className="w-full">
        <img 
        className="border-2 border-rounded rounded-xl w-[32rem] h-[16rem]"
        src={props.url} 
        alt={props.alt}>
        </img>
      </div>
    </div>
  )
}

export default PhotoCards