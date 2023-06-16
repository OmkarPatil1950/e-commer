

import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const RegistrationForm = () => {
  const [password, setPassword] = useState("");
  const [mobile_num, setMobileNum] = useState("");
  const [first_name, setFirstName] = useState("");
  const [last_name, setLastName] = useState("");
  const [email_id, setEmail] = useState("");
  const [address, setAddress] = useState("");
  const [username, setUsername] = useState("");
  const [errors, setErrors] = useState({});
  const requiredFieldClass = "text-red-500";
  const [showSlideMessage, setShowSlideMessage] = useState(false);
  const navigate = useNavigate();

  const handleFirstNameChange = (event) => {
    setFirstName(event.target.value);
  };

  const handleLastNameChange = (event) => {
    setLastName(event.target.value);
  };

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handleEmailChange = async (event) => {
    console.log(event.target.value);

    setEmail(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleMobileChange = (event) => {
    setMobileNum(event.target.value);
  };

  const handleAddressChange = (event) => {
    setAddress(event.target.value);
  };
  const message = () => {
    setShowSlideMessage(true);
    setTimeout(() => {
      setShowSlideMessage(false);
    }, 3000);
  };

  const validateForm = () => {
    const errors = {};

    // Validate first name
    if (!first_name.trim()) {
      errors.firstName = "First name is required";
    }

    // Validate last name
    if (!last_name.trim()) {
      errors.lastName = "Last name is required";
    }

    // Validate username
    if (!username.trim()) {
      errors.username = "Username is required";
    }

    // Validate email
    if (!email_id.trim()) {
      errors.email = "Email is required";
    } else if (!/\S+@\S+\.\S+/.test(email_id)) {
      errors.email = "Invalid email format";
    }

    // Validate password
    if (!password.trim()) {
      errors.password = "Password is required";
    } else if (password.length < 6) {
      errors.password = "Password should be at least 6 characters long";
    }

    // Validate mobile number
    if (!mobile_num.trim()) {
      errors.mobile = "Mobile number is required";
    } else if (!/^\d{10}$/.test(mobile_num)) {
      errors.mobile = "Mobile number should be a 10-digit number";
    }

    // Validate address
    if (!address.trim()) {
      errors.address = "Address is required";
    }

    setErrors(errors);

    return Object.keys(errors).length === 0;
  };
  const data = {
    first_name,
    last_name,
    username,
    mobile_num,
    address,
    email_id,
    password,
  }
  console.log(email_id)


  const handleSubmit = async (event) => {
  event.preventDefault();

  if (validateForm()) {
    try {
      const response = await fetch(`http://localhost:8080/api/customer/${email_id}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (response.ok) {
        const result = await response.text();
        const randomNumber = result.substring(result.lastIndexOf('.') + 1);
        console.log(randomNumber);
        alert(`Email sent!`);

        navigate("/Verify", { state: { randomNumber, data } });
      } else {
        alert("The email does not exist");
      }
    } catch (error) {
      console.log("Error:", error);
      alert("The email does not exist or enter correct values");
    }
  }
};


  return (
    <div>
      <div className="flex flex-col items-center min-h-screen pt-6 sm:justify-center sm:pt-0  mb-4">
        <div>
          <a href="/">
            <h5 className="text-3xl font-bold text-emerald-600">Register</h5>
          </a>
        </div>

        <div className="w-full px-6 py-4 mt-2 overflow-hidden bg-white shadow-md sm:max-w-lg sm:rounded-lg">
          <form onSubmit={handleSubmit}>
            <div className="flex ">
              <label
                htmlFor="first_name"
                className="line text-sm font-medium text-gray-700 "
              >
                First Name<span className={requiredFieldClass}>*</span>
              </label>
              <div className="flex">
                <input
                  type="text"
                  name="first_name"
                  placeholder="Enter first name"
                  className={`peer relative h-10 mr-2 w-40 rounded border border-slate-200 px-4 text-sm text-slate-500 outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400 ${errors.firstName ? "border-red-500" : ""
                    }`}
                  value={first_name}
                  onChange={handleFirstNameChange}
                  required
                />
              </div>
              {errors.firstName && (
                <p className="text-red-500">{errors.firstName}</p>
              )}
              <label
                htmlFor="last_name"
                className="block text-sm font-medium text-gray-700"
              >
                Last Name<span className={requiredFieldClass}>*</span>
              </label>
              <div className="flex">
                <input
                  type="text"
                  name="last_name"
                  placeholder="Enter last name"
                  className={`peer relative h-10 w-40 rounded border border-slate-200 px-4 text-sm text-slate-500  outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400 ${errors.lastName ? "border-red-500" : ""
                    }`}
                  value={last_name}
                  onChange={handleLastNameChange}
                  required
                />
              </div>
              {errors.lastName && (
                <p className="text-red-500">{errors.lastName}</p>
              )}
            </div>
            <div className="mt-4">
              <label
                htmlFor="email"
                className="block text-sm font-medium text-gray-700"
              >
                Email<span className={requiredFieldClass}>*</span>
              </label>
              <div className="flex flex-col items-start">
                <input
                  type="email"
                  name="email"
                  placeholder="Enter your email"
                  className={`peer relative h-10 w-full rounded border border-slate-200 px-4 text-sm text-slate-500  outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400 ${errors.email ? "border-red-500" : ""
                    }`}
                  value={email_id}
                  onChange={handleEmailChange}
                  required
                />
              </div>
              {errors.email && <p className="text-red-500">{errors.email}</p>}
            </div>
            <div className="mt-4">
              <label
                htmlFor="username"
                className="block text-sm font-medium text-gray-700"
              >
                Username<span className={requiredFieldClass}>*</span>
              </label>
              <div className="flex flex-col items-start">
                <input
                  type="text"
                  name="username"
                  placeholder="Enter your username"
                  className={`peer relative h-10 w-full rounded border border-slate-200 px-4 text-sm text-slate-500  outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400 ${errors.username ? "border-red-500" : ""
                    }`}
                  value={username}
                  onChange={handleUsernameChange}
                  required
                />
              </div>
              {errors.username && (
                <p className="text-red-500">{errors.username}</p>
              )}
            </div>
            <div className="mt-4">
              <label
                htmlFor="password"
                className="block text-sm font-medium text-gray-700"
              >
                Password<span className={requiredFieldClass}>*</span>
              </label>
              <div className="flex flex-col items-start">
                <input
                  type="password"
                  name="password"
                  placeholder="Enter your password"
                  className={`peer relative h-10 w-full rounded border border-slate-200 px-4 text-sm text-slate-500  outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400 ${errors.password ? "border-red-500" : ""
                    }`}
                  value={password}
                  onChange={handlePasswordChange}
                  required
                />
              </div>
              {errors.password && (
                <p className="text-red-500">{errors.password}</p>
              )}
            </div>
            <div className="mt-4">
              <label
                htmlFor="mobile_num"
                className="block text-sm font-medium text-gray-700"
              >
                Mobile Number<span className={requiredFieldClass}>*</span>
              </label>
              <div className="flex flex-col items-start">
                <input
                  type="text"
                  name="mobile_num"
                  placeholder="Enter your mobile number"
                  className={`peer relative h-10 w-full rounded border border-slate-200 px-4 text-sm text-slate-500  outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400 ${errors.mobile ? "border-red-500" : ""
                    }`}
                  value={mobile_num}
                  onChange={handleMobileChange}
                  required
                />
              </div>
              {errors.mobile && <p className="text-red-500">{errors.mobile}</p>}
            </div>
            <div className="mt-4">
              <label
                htmlFor="address"
                className="block text-sm font-medium text-gray-700"
              >
                Address<span className={requiredFieldClass}>*</span>
              </label>
              <div className="flex flex-col items-start">
                <input
                  type="textarea"
                  name="address"
                  placeholder="Enter your address"
                  className={`peer relative h-20 w-full rounded border border-slate-200 px-4 text-sm text-slate-500  outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400 ${errors.address ? "border-red-500" : ""
                    }`}
                  value={address}
                  onChange={handleAddressChange}
                  required
                />
              </div>
              {errors.address && (
                <p className="text-red-500">{errors.address}</p>
              )}
            </div>
            <div className="flex items-center mt-4">
              <button
                className="w-full px-4 py-2 tracking-wide text-white transition-colors duration-200 transform bg-emerald-500 rounded-md hover:bg-emerald-700 focus:outline-none"
                type="submit"
              >
                Register
              </button>
            </div>
          </form>
          <div className="mt-4 text-grey-600">
            Already have an account?{" "}
            <span>
              <a
                className="text-emerald-600 hover:underline"
                href="/Login"
              >
                Log in
              </a>
            </span>
          </div>
        </div>
      </div>
      {showSlideMessage && (
        <div className="absolute top-16 right-10 p-2 bg-green-500 text-white">
          Registration Successfull
        </div>
      )}
    </div>
  );
};

export default RegistrationForm;
