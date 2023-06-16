import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
export default function CardForm() {
  const [email_id, setEmail_id] = useState("");
  const [password, setPassword] = useState("");
  const [loggedIn, setLoggedIn] = useState(false);
  const navigate = useNavigate();

  const handleLogin = async (event) => {
    event.preventDefault();
    console.log(sessionStorage.getItem("email"));
    console.log("if")


    if (!email_id || !password) {
      // Show an error message or prevent form submission
      alert("enter the field")
      return;
    }



    if (!localStorage.getItem('email')) { // Corrected typo: changed `isLoggedIn` to `loggedIn`
      try {
        const response = await fetch("http://localhost:8080/admins/login", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            email_id,
            password,
          }),
        });

        if (response.ok) {
          sessionStorage.setItem('email', email_id);
          sessionStorage.setItem('password', password);
          console.log("Response ok")
          console.log(sessionStorage.getItem("email"));
          setLoggedIn(true);
          console.log(response.status);
          console.log(response)
          console.log(loggedIn)
          alert("Logged in successfully");
          navigate("/api/admin");
        } else {
          alert("Invalid username or password");
          console.log(response.status)
          console.log(response)
        }
      } catch (err) {
        alert("An error occurred. Please try again.");
      }
    } 
    else {
      alert("Already logged in");
    }
  };

  const handleLogout = () => {
    console.log("handle log out")
    console.log(sessionStorage.getItem("email"));
    sessionStorage.removeItem("email");
    sessionStorage.removeItem("password");
    console.log(sessionStorage.getItem("email"));

    setLoggedIn(false);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleEmailChange = (event) => {
    const input = event.target.value;
    const emailRegex = /^[a-zA-Z0-9@.]+$/;

    if (input === "" || emailRegex.test(input)) {
      setEmail_id(input);
    }
  };

  const isLoggedIn = () => {
    return (
      loggedIn ||
      (sessionStorage.getItem("email") && sessionStorage.getItem("password"))
    );
  };

  return (
    <>
      {/*<!-- Component: Card with form --> */}
      <form className="overflow-hidden rounded bg-white text-slate-500 shadow-md shadow-slate-200">
        {/*  <!-- Body--> */}
        <div className="p-6">
          <header className="mb-4 text-center">
            <h3 className="text-xl font-medium text-slate-700">Admin Login</h3>
          </header>
          <div className="flex flex-col space-y-8">
            {/*      <!-- Input field --> */}
            <div className="relative my-6 self-center">
              <input
                id="id-b03"
                type="email"
                placeholder="Your email"
                value={email_id} // Check that the value is correctly bound
                required
                className="peer relative h-10 w-96 rounded border border-slate-200 px-4 text-sm text-slate-500 placeholder-transparent outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400"
                onChange={handleEmailChange}
              />
              <label
                htmlFor="id-b03"
                className="absolute left-2 -top-2 z-[1] px-2 text-xs text-slate-400 transition-all before:absolute before:top-0 before:left-0 before:z-[-1] before:block before:h-full before:w-full before:bg-white before:transition-all peer-placeholder-shown:top-2.5 peer-placeholder-shown:text-sm peer-required:after:text-pink-500 peer-required:after:content-['\00a0*'] peer-invalid:text-pink-500 peer-focus:-top-2 peer-focus:text-xs peer-focus:text-emerald-500 peer-invalid:peer-focus:text-pink-500 peer-disabled:cursor-not-allowed peer-disabled:before:bg-transparent"
              >
                Your email
              </label>
              <small className="absolute flex w-full justify-between px-4 py-1 text-xs text-slate-400 transition peer-invalid:text-pink-500">
                <span>Type your email address</span>
              </small>
            </div>
            {/*      <!-- Input field --> */}
            <div className="relative my-6 self-center">
              <input
                id="id-b13"
                type="password"
                placeholder="Your password"
                value={password}
                className="peer relative h-10 w-96 rounded border border-slate-200 px-4 pr-12 text-sm text-slate-500 placeholder-transparent outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400"
                onChange={handlePasswordChange}
               required/>
              <label
                htmlFor="id-b13"
                className="absolute left-2 -top-2 z-[1] px-2 text-xs text-slate-400 transition-all before:absolute before:top-0 before:left-0 before:z-[-1] before:block before:h-full before:w-full before:bg-white before:transition-all peer-placeholder-shown:top-2.5 peer-placeholder-shown:text-sm peer-required:after:text-pink-500 peer-required:after:content-['\00a0*'] peer-invalid:text-pink-500 peer-focus:-top-2 peer-focus:text-xs peer-focus:text-emerald-500 peer-invalid:peer-focus:text-pink-500 peer-disabled:cursor-not-allowed peer-disabled:text-slate-400 peer-disabled:before:bg-transparent">
                Your password
              </label>
              <small className="absolute flex w-full justify-between px-4 py-1 text-xs text-slate-400 transition peer-invalid:text-pink-500">
                <span>Type your password</span>
              </small>
            </div>

            {/*  <!-- Action base sized basic button --> */}
            <div className="flex p-6 self-center">
              <button
                className="inline-flex h-10 mr-2 w-4 items-center justify-center gap-2 whitespace-nowrap rounded bg-emerald-500 px-20 text-sm font-medium text-white hover:bg-emerald-600"
                onClick={handleLogin}
              >
                <span>Login</span>
              </button>


              <button
                className="inline-flex h-10  w-4 items-center justify-center gap-2 whitespace-nowrap rounded bg-emerald-500 px-20 text-sm font-medium text-white hover:bg-emerald-600"
                onClick={handleLogout}
              >
                <span>Logout</span>
              </button>
            </div>
          </div>
        </div>
      </form>
      {/*<!-- End Card with form --> */}
    </>
  );
}
