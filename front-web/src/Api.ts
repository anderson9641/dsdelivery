import axios from "axios";

const Api_Uri = "http://localhost:8080";
const mapboxToken = process.env.REACT_APP_ACESS_TOKEN_MAP_BOX;

export function fetchProduct(){
    return axios(`${Api_Uri}/products`)
}

export function fetchLocalMapBox(local: string){
    return axios(`https://api.mapbox.com/geocoding/v5/mapbox.places/${local}.json?access_token=${mapboxToken}`)
}