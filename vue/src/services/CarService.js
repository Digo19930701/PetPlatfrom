import axios from 'axios';

class CarService{
    getCars(){
<<<<<<< HEAD
        // return axios.get('http://10.0.101.44:3306/items');
        return axios.get('http://localhost:8080/items');
=======
        
        return axios.get('http://localhost:8080/4a2b/shoppingCart/2');
>>>>>>> origin/L
    }
}

export default new CarService();