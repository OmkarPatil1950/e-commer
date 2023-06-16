import React from "react";

import { useEffect,useState } from "react";
import { useNavigate } from "react-router-dom";

export default function OrderDetails2() {
  const [data, setData] = useState([]);
  const [custid,setCustid]= useState(0);
  const email_id = sessionStorage.getItem('email');
  const [customer, setCustomer] = useState({});
  const navigate = useNavigate();
  const [cartid,setCartid]= useState(0);
  useEffect(() => {
    fetch(`http://localhost:8080/api/getbyemail/${email_id}`)
      .then((res) => res.json())
      .then((data) => {
        setCustomer(data[0]);
        setCustid(data[0].customer_Id);
        console.log("customer", data);
        console.log("cust id");
        console.log(custid)
      })
      .catch((err) => console.log(err));
  }, [email_id]);
  console.log("cust")
  console.log(customer)

  useEffect(() => {
    if (customer) {
      fetch(`http://localhost:8080/api/orders/${custid}`)
        .then((res) => res.json())
        .then((result) => {
          setData(result);
          console.log("cart details", result);
          // setCartid(result[0][7])
          console.log(cartid)
          console.log(result[0][7])
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }, [customer]);
  const currentDate = new Date().toLocaleDateString(); // Get today's date

  return (
   
      
<> 
{/*<!-- Component: Simple Table --> */}
{data.length >0 ? (
<div className="w-full overflow-x-auto">
 <table className="w-full text-left border border-collapse rounded sm:border-separate border-slate-200" cellspacing="0">
   <tbody>
     <tr>
       <th scope="col" className="h-12 px-6 text-sm font-medium border-l first:border-l-0 stroke-slate-700 text-slate-700 bg-slate-100">First Name</th>
       <th scope="col" className="h-12 px-6 text-sm font-medium border-l first:border-l-0 stroke-slate-700 text-slate-700 bg-slate-100">Last_Name</th>
       <th scope="col" className="h-12 px-6 text-sm font-medium border-l first:border-l-0 stroke-slate-700 text-slate-700 bg-slate-100">Order_Date</th>
       <th scope="col" className="h-12 px-6 text-sm font-medium border-l first:border-l-0 stroke-slate-700 text-slate-700 bg-slate-100">Quantity</th>
       {/* <th scope="col" className="h-12 px-6 text-sm font-medium border-l first:border-l-0 stroke-slate-700 text-slate-700 bg-slate-100">Order_Total</th> */}
     </tr>
     {data.map((cat) => (
     <tr>
       <td className="h-12 px-6 text-sm transition duration-300 border-t border-l first:border-l-0 border-slate-200 stroke-slate-500 text-slate-500 ">{customer.first_name}</td>
       <td className="h-12 px-6 text-sm transition duration-300 border-t border-l first:border-l-0 border-slate-200 stroke-slate-500 text-slate-500 ">{customer.last_name}</td>
       <td className="h-12 px-6 text-sm transition duration-300 border-t border-l first:border-l-0 border-slate-200 stroke-slate-500 text-slate-500 ">{cat[0]}</td>
       <td className="h-12 px-6 text-sm transition duration-300 border-t border-l first:border-l-0 border-slate-200 stroke-slate-500 text-slate-500 ">{cat[2]}</td>
       {/* <td className="h-12 px-6 text-sm transition duration-300 border-t border-l first:border-l-0 border-slate-200 stroke-slate-500 text-slate-500 ">{cat[3]}</td>1 */}
     </tr>
      ))}
   </tbody>
 </table>
</div>
) : (
  <h3>Place your first order</h3>
)}




    </>
  );
}