import axios from 'axios';

class CarService{
    getCars(){
        // return axios.get('http://localhost:8080/ecpayCheckout');//綠界
        return axios.get('http://localhost:8080/shoppingCart');
    }
}

export default new CarService();