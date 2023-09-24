import React from 'react'
import MemoryButton from './MemoryButton'

const MemoryNav = () => {
  return (
    <div className="bg-green-300 w-6/12 px-6 py-3 text-center rounded-xl flex">
        <MemoryButton text="All" selected={true} />
        <MemoryButton text="Image" selected={false} />
        <MemoryButton text="Video" selected={false} />
        <MemoryButton text="Audio" selected={false} />
        <MemoryButton text="Text" selected={false} />
    </div>
  )
}

export default MemoryNav