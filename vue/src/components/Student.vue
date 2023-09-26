<template>
    <div class = "container">
            
            <h1 class = "text-center"> Students List</h1>

            <table class = "table table-striped">
                <thead>
                    <tr>
                        <th> Student Name</th>
                        <th> Student Age</th>
                    </tr>

                </thead>
                <tbody>
                    <tr v-for="student in students" v-bind:key="student.age">
                        <td> {{student.name }}</td>
                        <td> {{student.age }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
</template>

<script>

// import EmployeeService from '../services/EmployeeService';
import StudentService from '../services/StudentService';

export default {
    name: 'Students',
    data(){
        return {
            students: []
        }
    },
    methods: {
        getStudents(){
            console.log('try to get student')
            StudentService.getStudents().then((response) => {
                let resData = {}
                if (response.status == 200){
                    resData = response.data
                    this.students.push(resData)   
                    console.log('student: '+ this.students[0].name)

                }
                // console.log('try to get student response:'+response["name"])
                
            });
        }
    },
    created() {
        this.getStudents();
    }
}

</script>