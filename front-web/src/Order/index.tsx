import './style.css';
import StepsHeader from './StepsHeader';
import ProductList from './ProductList';
import { useEffect, useState } from 'react';
import { OrderLocationData, Product } from './Types';
import {fetchProduct} from '../Api';
import OrderLocation from './OrderLocation';

function Orders(){
    const [orderLocation, setOrderLocation]= useState<OrderLocationData>();
    const [products, setProducts] = useState<Product[]>([]);
    console.log(products);

    useEffect(()=>{
        fetchProduct()
            .then(response => setProducts(response.data))
            .catch(error => console.log(error))
    }, [])

    return(
        <div>
            <StepsHeader/>
            <ProductList products={products}/>
            <OrderLocation onChangeLocation={location => setOrderLocation(location)}/>
        </div>
    )
}

export default Orders;