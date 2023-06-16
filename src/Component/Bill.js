import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
export default function Bill() {
  const [billingData, setBillingData] = useState([]);
  const email_id = sessionStorage.getItem('email');
  const { code } = useParams();
  const cartid = code; // Remove the square brackets
  const navigate=useNavigate();
  console.log("cart id list");
  console.log(cartid);

  useEffect(() => {
    console.log("inside useEffect ------------------------------");
    // Fetch billing data from the server
    fetchBillingData();

    
   

    // Add empty dependency array to run the effect only once
  }, []);

  const fetchBillingData = () => {
    fetch(`http://localhost:8080/bill/${email_id}`)
      .then((response) => response.json())
      .then((data) => {
        setBillingData(data);
        console.log('bill', data); // Moved console.log here to log the received data
        console.log(data[8]);
      })
      .catch((error) => console.log(error));
  };

  const handlePay = () => {
    // Implement the logic for handling the payment
    window.print();
  };

  const calculateTotalCost = () => {
    const total = billingData.reduce((acc, billingItem) => {
      const discountedPrice = (billingItem[6] * billingItem[3]) - (billingItem[6] * billingItem[3]) * 0.1;
      return acc + discountedPrice;
    }, 0);
    return total.toFixed(2);
  };

  const handleorder = () => {
    const currentDate = new Date().toISOString().split('T')[0]; // Get current date in ISO format
    const data = {
      order_Date: currentDate,
      order_Total: 0,
      cart_Id_fk: cartid, // Remove the nested object structure
    };
    console.log("data is the");
    console.log(data);

    fetch(`http://localhost:8080/api/addorders/${cartid}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });
    window.print();
    navigate('/order')
    console.log("handle");
  };

  return (
    <div className="flex justify-center mb-5">
      <div>
        <h2>Billing Page</h2>
        <table className="border-collapse border">
          <thead>
            <tr>
              <th className="border px-4 py-2">Product Image</th>
              <th className="border px-4 py-2">Product Name</th>
              <th className="border px-4 py-2">Price/unit</th>
              <th className="border px-4 py-2">Quantity</th>
              <th className="border px-4 py-2">Total Cost</th>
              <th className="border px-4 py-2">Discounted Price</th>
            </tr>
          </thead>
          <tbody>
            {billingData.map((billingItem, index) => (
              <tr key={index}>
                <td className="border px-4 py-2">
                  <img className="h-64" src={billingItem[1]} alt="Product" />
                </td>
                <td className="border px-4 py-2">{billingItem[2]}</td>
                <td className="border px-4 py-2">&#8377;{billingItem[3]}</td>
                <td className="border px-4 py-2">{billingItem[6]}</td>
                <td className="border px-4 py-2">&#8377;{billingItem[7]}</td>
                <td className="border px-4 py-2">
                  &#8377;
                  {((billingItem[6] * billingItem[3]) - (billingItem[6] * billingItem[3]) * 0.1).toFixed(2)}
                </td>
              </tr>
            ))}
          </tbody>
          <tfoot>
            <tr>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td>
                <b>Total Cost :</b>
              </td>
              <td>
                <b>&#8377;{calculateTotalCost()}</b>
              </td>
            </tr>
          </tfoot>
        </table>
        <div className='text-center mt-3'>
          <button className="bg-green-500 text-white font-bold py-2 px-4 rounded ml-2 mb-4" onClick={handlePay}>
            Print Bill
          </button>
          <button className="bg-green-500 text-white font-bold py-2 px-4 rounded ml-2 mb-4" onClick={handleorder}>
            View Orders
          </button>
        </div>
      </div>
    </div>
  );
}
