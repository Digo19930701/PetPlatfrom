import axios from 'axios';

class CarService{
    getCars(){
        // return axios.get('http://10.0.101.44:3306/items');
        return axios.get('http://localhost:8080/items');
    }
}

export default new CarService();