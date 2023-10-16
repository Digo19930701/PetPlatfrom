import axios from 'axios';

const UserURL = 'http://localhost:3300/4A2Bpet/Login';

class UserService{

    async getuserJSON(){
        const res = await axios.get(UserURL);
        console.log(res)
        return res;
    }
}

export default new UserService();