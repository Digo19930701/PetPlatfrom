import axios from 'axios';

const SO_API_BASE_URL = 'http://localhost:3300/4A2Bpet/ordertest';
const PETSERVICE_EDIT_RUL = "http://localhost:3300/4A2Bpet/sellers/services/SERVICE1" //先測試SERVICE1

class SellerOrderService{

    async getSellerOrder(){
        const res = await axios.get(SO_API_BASE_URL);
        console.log(res)
        return res;
    }

    async getServiceById(){
        const res = await axios.get(PETSERVICE_EDIT_RUL);
        console.log(res)
        return res;
    }

    getSellerInfo(seller) {

        return axios.get(`http://localhost:3300/4A2Bpet/sellers/${seller}`)
      }
      // putSellerInfo(seller ,props){
      //   return axios.put(`http://localhost:3300/4A2Bpet/sellers/${seller}`,${props})
      // }
    
}

export default new SellerOrderService();
