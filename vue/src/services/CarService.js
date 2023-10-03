import axios from 'axios';

class CarService{
    getCars(){
        
        return axios.get('http://localhost:8080/4a2b/shoppingCart/2');
    }
}

export default new CarService();