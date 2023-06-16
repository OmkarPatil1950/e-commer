import React, { useState } from 'react';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { useLocation } from 'react-router-dom';

const EmailVerification = () => {
  const [num1, setNum1] = useState('');
  const [num2, setNum2] = useState('');
  const [num3, setNum3] = useState('');
  const [num4, setNum4] = useState('');
  const [concatenatedNum, setConcatenatedNum] = useState('');
  const navigate=useNavigate();
  useEffect(() => {
    // Update the concatenatedNum whenever any of the individual numbers change
    const concatenated = num1 + num2 + num3 + num4;
    setConcatenatedNum(concatenated);
  }, [num1, num2, num3, num4]);


  const location = useLocation();
  const { state } = location;

  const first_name = state?.data.first_name;
  const last_name = state?.data.last_name;
  const username = state?.data.username;
  const mobile_num = state?.data.mobile_num;
  const address = state?.data.address;
  const email_id = state?.data.email_id;
  const password = state?.data.password;
  const { randomNumber } = location.state || {};
  console.log(first_name);
  console.log("verify otp status")
  console.log(randomNumber)
  const handleNum1Change = (e) => {
    setNum1(e.target.value);
  };

  const handleNum2Change = (e) => {
    setNum2(e.target.value);
  };

  const handleNum3Change = (e) => {
    setNum3(e.target.value);
  };

  const handleNum4Change = (e) => {
    setNum4(e.target.value);
  };

  const handleVerifyAccount = async () => {
    console.log(concatenatedNum)
    console.log(randomNumber)
    if(concatenatedNum===randomNumber){
    try {
      const response = await fetch(`http://localhost:8080/api/addcustme`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
            first_name,
            last_name,
            username,
            mobile_num,
            address,
            email_id,
            password,
        }),
      });
    

      if (response.ok) {
        alert("Validated .................!!!");
        navigate("/")
      } else {
        alert("OTP does not match");
      }
    } catch (error) {
      console.log("Error:", error);
      alert("Wrong OTP ......!!!");
    }
  }
  else{
    alert("Invalid otp")  
  } 
  
  
  };

  return (
    <div className="relative flex min-h-screen flex-col justify-center overflow-hidden bg-gray-50 py-12">
      <div className="relative bg-white px-6 pt-10 pb-9 shadow-xl mx-auto w-full max-w-lg rounded-2xl" style={{ marginLeft: '10rem' }}>
        <div className="mx-auto flex w-full max-w-md flex-col space-y-16">
          <div className="flex flex-col items-center justify-center text-center space-y-2">
            <div className="font-semibold text-3xl">
              <p>Email Verification</p>
            </div>
            <div className="flex flex-row text-sm font-medium text-gray-400">
              <p>We have sent a code to your email ba**@dipainhouse.com</p>
            </div>
          </div>

          <div>
            
              <div className="flex flex-col space-y-16">
                <div className="flex flex-row justify-center items-center mx-auto w-full max-w-xs">
                  <div className="w-16 h-16">
                  <input
                  type="text"
                  className='peer relative h-20 mr-2 w-20 rounded-3xl border border-slate-200 px-4 text-sm text-slate-500 outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400 '
                  value={num1}
                  onChange={handleNum1Change}
                 
                />
                  </div>
                  <div className="w-16 h-16 ml-10">
                    <input
                      className="peer relative h-20 mr-2 w-20 rounded-3xl border border-slate-200 px-4 text-sm text-slate-500 outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400"
                      type="text"
                      name="num2"
                      id="num2"
                      value={num2}
                      onChange={handleNum2Change}
                      
                    />
                  </div>
                  <div className="w-16 h-16 ml-10">
                    <input
                      className="peer relative h-20 mr-2 w-20 rounded-3xl border border-slate-200 px-4 text-sm text-slate-500 outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400"
                      type="text"
                      name="num3"
                      id="num3"
                      value={num3}
                      onChange={handleNum3Change}
                     
                    />
                  </div>
                  <div className="w-16 h-16 ml-10">
                    <input
                      className="peer relative h-20 mr-2 w-20 rounded-3xl border border-slate-200 px-4 text-sm text-slate-500 outline-none transition-all autofill:bg-white invalid:border-pink-500 invalid:text-pink-500 focus:border-emerald-500 focus:outline-none invalid:focus:border-pink-500 disabled:cursor-not-allowed disabled:bg-slate-50 disabled:text-slate-400"
                      type="text"
                      name="num4"
                      id="num4"
                      value={num4}
                      onChange={handleNum4Change}
                      
                    />
                  </div>
                </div>

                <div className='mx-auto'>
                  <button className="flex flex-row h-2 items-center justify-center  w-24 rounded-2xl py-4 bg-blue-700 border-none text-white text-sm shadow-sm" onClick={handleVerifyAccount}>
                    Verify Account
                  </button>
                </div>

                {/* <div>
                  <div className="flex flex-row items-center justify-center text-center text-sm font-medium space-x-1 text-gray-500">
                    <p>Didn't receive code?</p> <a className="flex flex-row items-center text-blue-600" href="http://" target="_blank" rel="noopener noreferrer">Resend</a>
                  </div>
                </div> */}
              </div>
                
          </div>
        </div>
      </div>
    </div>
  );
};

export default EmailVerification; 