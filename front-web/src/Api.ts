import axios from "axios";
import {OrderPayload} from './Order/Types';

const Api_Uri = process.env.REACT_APP_API_URL;
const mapboxToken = process.env.REACT_APP_ACESS_TOKEN_MAP_BOX;

export function fetchProduct(){
    return axios(`${Api_Uri}/products`)
}

export function fetchLocalMapBox(local: string){
    return axios(`https://api.mapbox.com/geocoding/v5/mapbox.places/${local}.json?access_token=${mapboxToken}`)
}

export function saveOrder(payload: OrderPayload){
    return axios.post(`${Api_Uri}/orders`, payload);
}