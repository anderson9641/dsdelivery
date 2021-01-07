import './style.css';
import StepsHeader from './StepsHeader';
import ProductList from './ProductList';
import { useEffect, useState } from 'react';
import { Product } from './Types';
import {fetchProduct} from '../Api';

function Orders(){

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
        </div>
    )
}

export default Orders;