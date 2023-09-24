/*
Purpose: provide the routing for the website, 
and renders the navbar, which determines what page to show
Author: Luka Mitchell and Akira Fletcher.
Creation Date: 25th Aug.
*/

import { Routes, Route } from 'react-router-dom'
import './App.css'
import Login from './pages/Login'
import MainPage from './pages/MainPage'
import Navbar from './components/Navbar'
import Signup from './pages/Signup'
import EnterDetails from './pages/EnterDetails'
import Welcome from './pages/Welcome'
import HomePage from './pages/HomePage'
import ViewMemory from './pages/ViewMemory'
import UploadMemory from './pages/UploadMemory'

function App() {
  const username = localStorage.getItem("username")
    return (
    <>
      <Navbar isLoggedIn={username}/>
      <Routes>
        <Route path="/view" element={<ViewMemory />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/" element={<MainPage />} />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<Signup />} />
        <Route path="/enterDetails" element={<EnterDetails />} />
        <Route path="/welcome" element={<Welcome />} />
        <Route path="/upload" element={<UploadMemory />} />
      </Routes>
    </>
  )
}

export default App
