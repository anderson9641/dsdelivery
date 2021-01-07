import axios from "axios";

const Api_Uri = "http://localhost:8080";

export function fetchProduct(){
    return axios(`${Api_Uri}/products`)
}