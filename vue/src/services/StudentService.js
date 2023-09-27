import axios from 'axios';

const STUDENT_API_BASE_URL = 'http://localhost:3300/4A2Bpet/student/allstudent';

class StudentService{

    async getStudents(){
        const res = await axios.get(STUDENT_API_BASE_URL);
        console.log(res)
        return res;
    }
}

export default new StudentService();
