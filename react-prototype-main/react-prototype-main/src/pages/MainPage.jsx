/*
Purpose: provide the main webpage where users can click to signup/login,
then browse their photocards
Author: Luka Mitchell and Akira Fletcher.
Creation Date: 25th Aug.
*/

import React from 'react'
import PhotoCards from '../components/PhotoCards'

const MainPage = () => {  
  return (
    <div className="w-full justify-center items-center p-6 bg-green-50">
      <div className="w-6/12 translate-x-2/4"> 
        <h1 className="font-serif text-center p-5 text-2xl w-full">
        Create the most personalized digital album that holds your memories.
        </h1>
      </div>
      <p className="font-serif text-center p-5">
      Upload any form of files to start creating your collection of memories, 
      we support many forms of media.
      </p>
      <div className="flex justify-center items-center">
        <PhotoCards 
        url="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Compact_disc_album.jpg/1200px-Compact_disc_album.jpg"
        alt="album cd" 
        text="Audio"/>
        <PhotoCards 
        url="https://media.istockphoto.com/id/486507435/photo/happy-family-photo.jpg?s=612x612&w=0&k=20&c=6ZewbJW5nbJwGG_3rtitI2IoTAVzk2EpJ-8aA6wvjDY=" 
        alt="family image" 
        text="Image"/>
        <PhotoCards 
        url="https://www.wordstream.com/wp-content/uploads/2017/12/best-video-editing-software-beginners-apple.png" 
        alt="videos" 
        text="Video"/>
      </div>
    </div>
  )
}

export default MainPage