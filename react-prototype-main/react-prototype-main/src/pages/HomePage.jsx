import React from 'react'
import MemoryCards from '../components/MemoryCards'
import MemoryNav from '../components/MemoryNav'

const HomePage = () => {
  const handleClick = (event, type) => {
    event.preventDefault();
    if (type == "view") {
      window.location.href = "/view";
    } else if (type == "upload") {
      window.location.href = "/upload";
    }
  }

  return (
    <div className="w-full p-6 bg-green-50" >
        <div className="flex justify-center m-10">
            <MemoryNav />
        </div>
        <div className="flex items-center justify-center">
            <div className="grid grid-cols-2 grid-rows-2 gap-20">
                <MemoryCards 
                url="https://t4.ftcdn.net/jpg/00/97/58/97/360_F_97589769_t45CqXyzjz0KXwoBZT9PRaWGHRk5hQqQ.jpg"
                alt="card1"
                text="card 1"
                onClick={(event) => handleClick(event, "view")}/>
                <MemoryCards 
                url="https://t4.ftcdn.net/jpg/00/97/58/97/360_F_97589769_t45CqXyzjz0KXwoBZT9PRaWGHRk5hQqQ.jpg"
                alt="card2"
                text="card 2"
                onClick={(event) => handleClick(event, "view")}/>
                <MemoryCards 
                url="https://t4.ftcdn.net/jpg/00/97/58/97/360_F_97589769_t45CqXyzjz0KXwoBZT9PRaWGHRk5hQqQ.jpg"
                alt="card3"
                text="card 3"
                onClick={(event) => handleClick(event, "view")}/>
                <MemoryCards 
                url=""
                alt="Upload"
                text="Upload"
                onClick={(event) => handleClick(event, "upload")}/>
            </div>
        </div>
    </div>
  )
}

export default HomePage