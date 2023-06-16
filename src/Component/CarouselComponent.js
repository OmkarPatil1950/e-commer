import React from 'react';
import { Carousel } from 'react-responsive-carousel';
import 'react-responsive-carousel/lib/styles/carousel.min.css';

const CarouselComponent = () => {
  return (
    <Carousel
    className='mt-2'
      showStatus={false}
      showThumbs={false}
      infiniteLoop={true}
      autoPlay={true}
      interval={2000}
    >


<a href='/productsByCat/19'>
      <div> 
       <img src="../images/bg11.jpg" alt="Carousel Image 1" /> 
      </div>
      </a>
      
      <a href='productsByCat/6'>
      <div>
        <img src="../images/bg6.jpg" alt="Carousel Image 2" />
      </div>
      </a>
     <a href='/productsByCat/15'>
      <div>
        <img src="../images/bg12.jpg" alt="Carousel Image 3" />
      </div>
      </a>
      <a href='/productsByCat/10'>
      <div>
        <img src="../images/bg7.jpg" alt="Carousel Image 3" />
      </div>
      </a>
      <a href='/productsByCat/16'>
      <div>
        <img src="../images/bg13.jpg" alt="Carousel Image 3" />
      </div>
      </a>
    </Carousel>
  );
};

export default CarouselComponent;
