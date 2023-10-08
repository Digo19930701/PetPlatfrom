import axios from 'axios'

class CarService {
  unsr ={"userEmail": "sam",
         "userName": "sam",
         "phoneNumber": "0933029976",
        }

  async getCars(userEmail="") {
    if (userEmail ==""){
      console.log("CarService.getCars 必須要填入email!")
      return
    }
    const res = await axios.get(`http://localhost:3300/4A2Bpet/shoppingCart?userEmail=${userEmail}`)
    // console.log(res)

    return res
  }

}

export default new CarService()
