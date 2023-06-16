import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Corosol from "./CarouselComponent"
import { Card } from 'react-bootstrap';
import TopOffers from "./Topoffers";



export default function Home() {
  const [Categories, setCategory] = useState([]);

  const navigate = useNavigate();
  useEffect(() => {
    fetch("http://localhost:8080/api/Categories")
      .then((res) => res.json())
      .then((result) => {
        setCategory(result);
        console.log(result)
      });
    console.log("----------------------")
    console.log(Categories);
    console.log("--------------------------");
    console.log(sessionStorage.getItem("email"));

  }, []);
  ;
  return (
    <div>
      <Corosol />
      <div className="bg-white">
      <div className="mx-auto max-w-2xl px-4 py-16 sm:px-6 sm:py-24 lg:max-w-7xl lg:px-8">
    <div className="mt-6 grid grid-cols-1 gap-4 sm:grid-cols-2 lg:grid-cols-5 xl:gap-8">
      {Categories.map((cat, ind) => (
        <a key={cat.id} href={`/subcategory/${cat.category_Id}`} className="text-center">
          <Card className="transition-transform hover:scale-110">
            <Card.Img variant="top" src={cat.category_Img_Path}  className="h-48 hover:" />
            <Card.Body>
              <Card.Title className="text-black">{cat.category_Name}</Card.Title>
            </Card.Body>
          </Card>
        </a>
      ))}
    </div>
  
</div>

      </div>
      <TopOffers></TopOffers>

    </div >
  )
}
