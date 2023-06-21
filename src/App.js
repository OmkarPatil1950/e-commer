import React from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Home from './Component/Home'
import About from './Component/About'
import HomeNavbar from './Component/HomeNavbar'
import Login from "./Component/Login"
import Subcategory from "./Component/subcategories"
import Product from './Component/products'
import Footer from './Component/footer'
import ContactUs  from './Component/ContactUs'
import ProductDetails from './Component/productDetails'
import Payment from './Component/payment'



import FormDialog from './Component/dialogform'
import RegistrationForm from './Component/RegistrationForm'
import Cart from './Component/cart'
import NotFoundPage from './Component/error'
import BillingPage from './Component/Bill'
import Invoice from './Component/Invoice'
import DisplaySelected from './Component/DisplaySelected';
import DeleteSelected from './Component/DeleteSelected';
import UpdateSelected from './Component/UpdateSelected';
import AddSelected from './Component/AddSelected';
import LinkData from './Component/LinkData';
import AdminLogin from './Component/AdminLogin';
import BUyNowBill from './Component/BUyNowBill'
import CartPayment from './Component/cartpagepayment'
import OrderDetails2 from './Component/Order'
import FAQ from './Component/FAQ'
import EmailVerification from './Component/EmailVerification'
import { Slide } from '@mui/material'
import SmokeCursor from './Component/smokemouse'
import View from './View'
import TryOn from './Component/tryon'

// import OTP from './Component/Otp'

export default function App() {
  return (
    <BrowserRouter>
      <HomeNavbar />
      <Routes>
        <Route exact path='/' element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path='/Login' element={<Login />} />
        <Route path='/subcategory/:code' element={<Subcategory />} />
          <Route path='/productsbycat/:code' element={<Product/>}/>
      <Route path='/contact' element={<ContactUs/>}/>
      <Route path='/about' element={<About/>}/>
      <Route path="/productdetails/:code" element={<ProductDetails />} />
      <Route path="/payment/:code" element={<Payment/>}/>
      <Route path="/cartpayment/:code" element={<CartPayment/>}/>
      <Route path='/sucess' element={<FormDialog/>}/>
      <Route path='Register' element={<RegistrationForm/>}/>
      <Route path='/cart' element={<Cart/>}/>
      <Route path='*' element={<NotFoundPage/>} />
      <Route path='/bill/:code' element={<BillingPage/>}/>
      <Route path='/buynowbill/:code' element={<BUyNowBill/>}/>
      <Route path='/invoice' element={<Invoice/>}/>
      <Route path="/api/adminlogin" element={<AdminLogin />} />
        <Route path="/api/admin" element={<LinkData/>} />
        <Route path="/updateselected/:url/:code" element={<UpdateSelected/>} />
        <Route path="/deleteselected/:url/:code" element={<DeleteSelected/>} />
        <Route path="/displayselected/:url/:code" element={<DisplaySelected/>} />
        <Route path="/addselected/:url" element={<AddSelected/>} />
        <Route path='/order' element={<OrderDetails2/>}/>
        <Route path='/FAQ' element={<FAQ/>}/>
        <Route path='/Verify' element={<EmailVerification/>}/>
        <Route path='/slide' element={<Slide/>}></Route>
        <Route path='/sm' element={<SmokeCursor/>}/>
        <Route path='/view360' element={<View/>}/>
        <Route path='/tryon' element={<TryOn/>}/>
      </Routes>
     {/* <Footer/> */}
    </BrowserRouter>
  )
}
