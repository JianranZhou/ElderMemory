import React from 'react'

const MemoryImage = (props) => {
  if (props.url != "") {
    return (
        <button onClick={props.onClick} className="w-full h-1/2 px-3 border-2 drop-shadow-md rounded-2xl p-5 bg-white">
          <img 
          className="w-full h-[16rem] 
          bg-white object-contain"
          src={props.url} 
          alt={props.alt}>
          </img>
        </button>
      )
  } else {
    return (
      <button className="w-full h-1/2 px-3 border-2 border-neutral-300 rounded-2xl drop-shadow-md p-5 flex justify-center items-center bg-neutral-200">
        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-64">
          <path strokeLinecap="round" strokeLinejoin="round" d="M12 6v12m6-6H6" />
        </svg>
      </button>
      )
  }
  
}

export default MemoryImage