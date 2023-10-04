import axios from 'axios'

const SO_API_BASE_URL = 'http://localhost:3300/4A2Bpet/ordertest'

class SellerOrderService {
  async getSellerOrder() {
    const res = await axios.get(SO_API_BASE_URL)
    console.log(res)
    return res
  }
}

export default new SellerOrderService()
