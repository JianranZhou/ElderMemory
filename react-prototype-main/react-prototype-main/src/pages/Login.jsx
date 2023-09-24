/*
Purpose: provides the login page, where users can enter their email 
and password to log into their account
Author: Luka Mitchell and Akira Fletcher.
Creation Date: 27th Aug.
*/

import React from 'react'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import axios from "axios";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    axios({
      methods: 'get',
      url: 'http://127.0.0.1:8080/demo/user/login',
      params: {
        username:email,
        password:password
      }
    }).then(res => {
      if (res.data.code === 0){
        window.location.href = "/welcome";
        localStorage.setItem("username",res.data.data.username)
      }else{
        alert(res.data.msg);
      }


    }).catch(err => {
      console.error(err);
    })
  }

  return (
    <div className="justify-center items-center p-5 h-screen">
      <div className="flex items-center flex-col p-3">
        <h1 className="text-4xl p-3 font-bold p-3">
        Login with your account
        </h1>
        <h2 
        className="text-lg text-center p-3 text-slate-500 
        font-normal leading-8">
        Or<br></br>
        Sign Up for 
        <span className="text-blue-500"> Free</span>
        </h2>
        <div className="border-solid border-slate-400 border-1 border-rounded 
        shadow-xl m-5 bg-white w-[30%]">
          <div className="flex p-0 mb-10 w-full">
            <div className="w-6/12 py-2 m-0">
              <p className="text-xl text-center font-bold">Login</p>
            </div>
            <div className="flex bg-gray-200 w-6/12 py-2 m-0 justify-center">
              <Link 
              to="/signup" 
              className="w-full text-center text-xl">
              Sign Up
              </Link>
            </div>
          </div>
          <form onSubmit={handleSubmit}>
            <div className="justify-center items-center flex">
              <input
              type="text" 
              name="Email" 
              value={email} 
              placeholder="Email" 
              onChange={(e)=>setEmail(e.target.value)} 
              className="border-2 border-gray-200 rounded-xl m-2 w-10/12 h-16 
              indent-2">
              </input>
            </div>
            <div className="justify-center items-center flex">
              <input 
              type="password" 
              name="Password" 
              value={password} 
              placeholder="Password"
              onChange={(e)=>setPassword(e.target.value)} 
              className="border-2 border-gray-200 rounded-xl m-2 w-10/12 h-16 
              indent-2">
              </input>
            </div>
            <div className="justify-center items-center flex">
              <input 
              type="submit" 
              value="Login" 
              className="border-1 border-gray-200 rounded-2xl bg-[#2699FB] 
              text-white font-bold px-3 py-1 m-5 w-5/12 h-16">
              </input>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}

export default Login