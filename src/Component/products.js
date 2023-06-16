
import { useEffect, useState } from "react"
import { Card } from "react-bootstrap";
import { useParams , useNavigate } from "react-router-dom";
// const products = [
//   {
//       Id:1,
//     name: 'Kitchen Appliances',
//     description: 'Work from home accessories',
//     imageSrc: '../images/kit01.png',
//     imageAlt: 'Pressure Cooker',
//     href: '#',
//     price:580,
//   },
//   {

//     Id:2,
//   name: 'Kitchen Appliances',
//   description: 'Work from home accessories',
//   imageSrc: '../images/kit02.png',
//   imageAlt: 'Gas Stove (2 Burners)',
//   href: '#',
//   price:3200,
// },
// {
//   Id:1,
// name: 'Kitchen Appliances',
// description: 'Work from home accessories',
// imageSrc: '../images/kit03.png',
// imageAlt: 'Gas Stove (1 Burners)',
// href: '#',
// price:2200,
// },
// {
//   Id:1,
// name: 'Kitchen Appliances',
// description: 'Work from home accessories',
// imageSrc: '../images/kit04.png',
// imageAlt: 'Appam Maker',
// href: '#',
// price:2750,
// },
// {
//   Id:1,
// name: 'Kitchen Appliances',
// description: 'Work from home accessories',
// imageSrc: '../images/kit05.png',
// imageAlt: 'Vegetable & Fruit Chopper',
// href: '#',
// price:300,
// },
// {
//   Id:1,
// name: 'Kitchen Appliances',
// description: 'Work from home accessories',
// imageSrc: '../images/kit06.png',
// imageAlt: 'Cookware Set',
// href: '#',
// price:2500,
// },
// {
//   Id:1,
// name: 'Kitchen Appliances',
// description: 'Work from home accessories',
// imageSrc: '../images/kit07.png',
// imageAlt: 'Manual Gas Stove (3 Burners)',
// href: '#',
// price:5000,
// },
// {
//   Id:1,
// name: 'Kitchen Appliances',
// description: 'Work from home accessories',
// imageSrc: '../images/kit08.png',
// imageAlt: 'Kitchen Plastic Jars ',
// href: '#',
// price:250,
// },
// {
//   Id:1,
// name: 'Kitchen Appliances',
// description: 'Work from home accessories',
// imageSrc: '../images/kit09.png',
// imageAlt: 'prayati Kitchen Containers Set',
// href: '#',
// price:1500,
// },
// {
//   Id:1,
// name: 'Kitchen Appliances',
// description: 'Work from home accessories',
// imageSrc: '../images/kit10.png',
// imageAlt: '5 Ltr Cooker',
// href: '#',
// price:850,
// },

//  {
//       Id:1,
//     name: 'Kitchen Appliances',
//     description: 'Work from home accessories',
//     imageSrc: '../images/kit11.png',
//     imageAlt: '3 Ltr Cooker',
//     href: '#',
//     price:700,
//   },
//   {
//     Id:1,
//   name: 'Kitchen Appliances',
//   description: 'Work from home accessories',
//   imageSrc: '../images/kit12.png',
//   imageAlt: '3 L Pressure Cooker',
//   href: '#',
//   price:850,
// },
// {
//   Id:1,
// name: 'Kitchen Appliances',
// description: 'Work from home accessories',
// imageSrc: '../images/kit13.png',
// imageAlt: 'Manual Gas Stove',
// href: '#',
// price:400,
// },

// {
//   Id:1,
// name: 'Kitchen Appliances',
// description: 'Work from home accessories',
// imageSrc: '../images/kit14.png',
// imageAlt: 'Glass Manual Gas Stove',
// href: '#',
// price:500,
// },
// {
//   Id:1,
// name: 'Kitchen Appliances',
// description: 'Work from home accessories',
// imageSrc: '../images/kit15.png',
// imageAlt: 'Grill Pan 23 cm',
// href: '#',
// price:850,
// },
// ]
export default function Productsbycat() {
  const { code } = useParams();
  const [Products, setProducts] = useState([]);
  const navigate=useNavigate();
  console.log(code + "------------------------------------------")
  useEffect(() => {
      fetch("http://localhost:8080/api/productsByCat/" + code).then(res => res.json())
          .then(result => {
              setProducts(result);
              console.log(result);
          }
          );
      console.log(Products);
  }, []);
 
  return (
    <div className="bg-white">
      <div className="mx-auto max-w-2xl px-4 py-16 sm:px-6 sm:py-24 lg:max-w-7xl lg:px-8">
        <h2 className="sr-only">Products</h2>

        <div className="grid grid-cols-1 gap-x-6 gap-y-10 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 xl:gap-x-8" >
          {Products.map((cat) => (
           <a key={cat.id} href={`/productdetails/${cat.p_Id}`}>
           <Card style={{ margin: "2%",backgroundColor: "white" }} className="card">
             <Card.Img variant="top" src={cat.p_Image} style={{ width: '100%', height: '180px' }} />
             <Card.Body>
               <Card.Title >{cat.p_Name}</Card.Title>
               <Card.Title style={{color:'blue'}}>&#8377; {cat.p_Price}</Card.Title>
               {/* Additional card text or content */}
             </Card.Body>
           </Card>
         </a>
          ))}
        </div>
      </div>
    </div>
  )
}
