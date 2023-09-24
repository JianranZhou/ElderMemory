import React from 'react'

const MemoryCards = (props) => {
  if (props.url != "") {
    return (
        <button onClick={props.onClick} className="w-full px-14 border-4 rounded-2xl p-5 bg-white">
          <div className="w-full p-3 py-5">
            <img 
            className="border-2 border-rounded rounded-xl w-[32rem] h-[16rem] 
            bg-gray-200 object-contain"
            src={props.url} 
            alt={props.alt}>
            </img>
          </div>
          <div className="p-3">
            <div className="flex items-end">
                <div className="w-10/12">
                    <h2 className="text-4xl">Title</h2>
                </div>
                <div className="w-2/12">
                    <p>Date</p>
                </div>
            </div>
            <div>
                <hr className="h-2"></hr>
            </div>
            <div>
                <p>Brief Description</p>
            </div>
          </div>
        </button>
      )
  } else {
    return (
        <button onClick={props.onClick} className="w-full px-14 border-4 rounded-2xl p-5 flex justify-center items-center bg-white">
            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-64">
                <path strokeLinecap="round" strokeLinejoin="round" d="M12 6v12m6-6H6" />
            </svg>
        </button>
      )
  }
  
}

export default MemoryCards