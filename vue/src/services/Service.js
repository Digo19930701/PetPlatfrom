import axios from 'axios';

const SELLER_ORDERLIST_URL = 'http://localhost:3300/4A2Bpet/sellers/SELLER1/orderList';  //先測試SELLER1
const PETSERVICE_EDIT_RUL = `http://localhost:3300/4A2Bpet/sellers/serviceTypes/SERVICE` //先測試SERVICE

class SellerOrderService{

    async getSellerOrder(){
        const res = await axios.get(SELLER_ORDERLIST_URL);
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
