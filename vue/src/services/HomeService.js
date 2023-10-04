import axios from 'axios'

const SO_API_BASE_URL = 'http://localhost:3300/4A2Bpet/Home/services/'

class HomeService {
  async getHome(service) {
    const res = await axios.get(SO_API_BASE_URL + service)
    console.log(res)
    return res
  }
}

export default new HomeService()
